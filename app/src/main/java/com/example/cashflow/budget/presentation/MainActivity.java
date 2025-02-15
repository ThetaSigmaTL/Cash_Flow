package com.example.cashflow.budget.presentation;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.viewpager2.widget.ViewPager2;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.cashflow.R;
import com.example.cashflow.budget.database.AppDatabase;
import com.example.cashflow.budget.database.AppDatabaseHolder;
import com.example.cashflow.budget.model.Account;
import com.example.cashflow.budget.model.AccountDao;
import com.example.cashflow.budget.model.Category;
import com.example.cashflow.budget.model.CategoryDao;
import com.google.android.material.tabs.TabLayout;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerStateAdapter viewPagerStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        initializingTabLayout();
        handleFirstRun();
    }
    // Настройка адаптера для viewpager2
    private void setupUI(){
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPagerStateAdapter = new ViewPagerStateAdapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(viewPagerStateAdapter);
    }
    private void setupDB(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_database").build();
        CategoryDao categoryDao = db.categoryDao();
    }
    // Проверка первого запуска приложения. Если первое, то добавляем в базу данных дефолтные значения категорий и счетов
    private void handleFirstRun(){
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("IsFirstRun", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() ->{
        if (isFirstRun){
            AppDatabase db = AppDatabaseHolder.getDatabase(getApplicationContext());
            CategoryDao categoryDao = db.categoryDao();
            if (categoryDao.getAll().isEmpty()){
                categoryDao.insert(new Category("Продукты",1));
                categoryDao.insert(new Category("Транспорт",2));
                categoryDao.insert(new Category("Связь и интернет",3));
                categoryDao.insert(new Category("Зарплата",4));
            }
            AccountDao accountDao = db.accountDao();
            if(accountDao.getAll().isEmpty()){
                accountDao.insert(new Account("Наличные", new BigDecimal(0)));
                accountDao.insert(new Account("Карты", new BigDecimal(0)));
                accountDao.insert(new Account("Счета", new BigDecimal(0)));
            }
        }
    });
    }

    // Настройка переключения табов
    public void initializingTabLayout(){

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }



}