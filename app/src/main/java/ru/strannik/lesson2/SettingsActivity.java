package ru.strannik.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
    private Button btn_Back;
    private Switch switchTheme;
    final static String SWITCH_THEME = "SWITCH_THEME";

    //имя настроек
    private static final String NameSharedPreference = "NAME";
    private static final String AppTheme = "APP_THEME";        //переменная для хранения темы
    private static final String switchT = "SWT_CHECKED";       //переменная для хранения состояния переключателя


    //имя параметра в настройках
    private static final int AppThemeLightCodeStyle = 1;
    private static final int AppThemeDarkCodeStyle = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.AppThemeLight));     //установка темы
        setContentView(R.layout.activity_settings);
        initViews();
        setOnBtnClickListener();
        ThemeChooser();                                   //смена темы (светлая/тёмная)
        if (isSwitchThemeChecked())
            switchTheme.setChecked(true);                 //восстановить состояние переключателя

    }
    //при переключении темы
    private void ThemeChooser() {
        final int codeStyle = 1;
        switchTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //сохраним настройки
                if (switchTheme.isChecked())
                    setAppTheme(AppThemeDarkCodeStyle);
                else
                    setAppTheme(AppThemeLightCodeStyle);
                recreate();
            }
        });
    }

    //сохранение настроек
    private void setAppTheme(int codeStyle) {
        //получение доступа к файлу настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //получение объекта Эдитор для сохранения настроек
        SharedPreferences.Editor editor = sharedPref.edit();
        //указание набора необходимых параметров к сохранению
        editor.putInt(AppTheme, codeStyle);
        editor.putBoolean(switchT, switchTheme.isChecked());
        //сохранение
        editor.apply();//отложенное, для немедленого commit
    }

    //выбор темы
    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleID(getCodeStyle(codeStyle));
    }
    //отпределение типа темы (светлая/тёмная)
    private int codeStyleToStyleID(int codeStyle) {
        switch (codeStyle) {
            case AppThemeLightCodeStyle:
                return R.style.AppThemeLight;
            case AppThemeDarkCodeStyle:
                return R.style.AppThemeDark;
        }
        return R.style.AppThemeLight;
    }

    //чтение настроек, парметр "тема"
    private int getCodeStyle(int codeStyle) {
        //получение доступа к файлу настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return
                sharedPref.getInt(AppTheme, codeStyle);

    }

    //чтение настроек, параметр статус переключателя
    private boolean isSwitchThemeChecked() {
        //получение доступа к файлу настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return
                sharedPref.getBoolean(switchT, switchTheme.isChecked());

    }

    //Обработка событий нажатий кнопок
    private void setOnBtnClickListener() {
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();
                setResult(RESULT_OK, intentResult);
                //для закрытия Активити
                finish();

            }
        });

    }

    //инициализация кнопки НАЗАД
    private void initViews() {
        btn_Back = findViewById(R.id.btn_Back);
        switchTheme = findViewById(R.id.switchTheme);
    }
}