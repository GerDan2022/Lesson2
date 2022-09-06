package ru.strannik.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

import java.util.Locale;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private Button button_0;
    private Button button_Del;
    private Button button_1;
    private Button button_Proc;
    private Button button_2;
    private Button button_C;
    private Button button_3;
    private Button button_Mult;
    private Button button_4;
    private Button button_Div;
    private Button button_5;
    private Button button_Summ;
    private Button button_6;
    private Button button_Ded;
    private Button button_7;
    private Button button_Equl;
    private Button button_8;
    private Button button_Sign;
    private Button button_9;
    private Button button_Dot;

    private EditText editText;
    private String myText = "0";
    private ImageButton btn_settings;

    private static final String NameSharedPreference = "NAME"; //имя настроек
    private static final String AppTheme = "APP_THEME";        //переменная для хранения темы
    private static final int REQUEST_CODE_SETTINGS_ACTIVITY = 1;

    //имя параметра в настройках
    private static final int AppThemeLightCodeStyle = 1;
    private static final int AppThemeDarkCodeStyle = 2;

    //при СОЗДАНИИ----------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.AppThemeLight));     //установка темы
        setContentView(R.layout.activity_main);           //установка активити
        initViews();                                      //инициализация кнопок
        setOnBtnClickListener();                          // события на кнопки
    }

    //выбор темы------------------------------------------------------------------------------------
    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleID(getCodeStyle(codeStyle));
    }

    //отпределение типа темы (светлая/тёмная)-------------------------------------------------------
    private int codeStyleToStyleID(int codeStyle) {
        switch (codeStyle) {
            case AppThemeLightCodeStyle:
                return R.style.AppThemeLight;
            case AppThemeDarkCodeStyle:
                return R.style.AppThemeDark;
        }
        return R.style.AppThemeLight;
    }

    //чтение настроек, парметр "тема"---------------------------------------------------------------
    private int getCodeStyle(int codeStyle) {
        //получение доступа к файлу настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return
                sharedPref.getInt(AppTheme, codeStyle);

    }
   //обработка результата который вернулся со второй активити---------------------------------------
    protected void onActivityResult(int requestCode, int resultCode, Intent settingsIntent) {
        if (requestCode != REQUEST_CODE_SETTINGS_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, settingsIntent);
            return;
        }
        if (resultCode == RESULT_OK)
            recreate();
    }

    //события на кнопки-----------------------------------------------------------------------------
    private void setOnBtnClickListener() {

        //при нажатии на кнопку Настройки
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //подготовим переменную Intent, для старта Активити НАСТРОЕК
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                //стартуем Активити НАСТРОЕК с ожиданием ОТВЕТА
                startActivityForResult(settingsIntent, REQUEST_CODE_SETTINGS_ACTIVITY);

            }
        });
        //при нажатии на "0"
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "0";
                } else if (isPossibleSetNull(myText))
                    myText = myText + "0";

                editText.setText(myText);
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "1";
                } else
                    myText = myText + "1";
                editText.setText(myText);

            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "2";
                } else
                    myText = myText + "2";
                editText.setText(myText);

            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "3";
                } else
                    myText = myText + "3";
                editText.setText(myText);

            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "4";
                } else
                    myText = myText + "4";
                editText.setText(myText);

            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "5";
                } else
                    myText = myText + "5";
                editText.setText(myText);

            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "6";
                } else
                    myText = myText + "6";
                editText.setText(myText);

            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "7";
                } else
                    myText = myText + "7";
                editText.setText(myText);

            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "8";
                } else
                    myText = myText + "8";
                editText.setText(myText);

            }
        });

        //кнопка "9"
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(myText, "0")) {
                    myText = "9";
                } else
                    myText = myText + "9";
                editText.setText(myText);

            }
        });

        //кнопка ТОЧКА
        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPossibleSetDot(myText))
                    myText = myText + ".";
                editText.setText(myText);

            }
        });

        //кнопка суммирования
        button_Summ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myText.length() > 0) {
                    if (!(myText.charAt(myText.length() - 1) == '+')) {
                        arifmeticSign(myText);
                        myText = myText + "+";
                        editText.setText(myText);
                    }
                }
                if (myText.length() > 0) {
                    int myPos = 0;
                    //если существует + найдем его позицию и присвоим myPos
                    if ((myText.indexOf('-') != -1) || (myText.indexOf('+') != -1) || (myText.indexOf('x') != -1) ||
                            (myText.indexOf('/') != -1)) myPos = (int) myText.indexOf('-');
                    //удалим лишний +
                    arifmeticSign(myText);
                    //запустим сложение
                    Calculation calculation = new Calculation();
                    String result = calculation.Calc(myText);
                    //вернем убранный + для дальнейшей работы
                    myText = result + "+";
                    //итог выведем на экран
                    editText.setText(myText);

                }
            }
        });

        //кнопка вычитания
        button_Ded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myText.length() > 0) {
                    if (!(myText.charAt(myText.length() - 1) == '-')) {
                        arifmeticSign(myText);
                        myText = myText + "-";
                        editText.setText(myText);
                    }
                }
                if (myText.length() > 0) {
                    int myPos = 0;
                    //если существует "-" найдем его позицию и присвоим myPos
                    if ((myText.indexOf('-') != -1) || (myText.indexOf('+') != -1) || (myText.indexOf('x') != -1) ||
                            (myText.indexOf('/') != -1)) myPos = (int) myText.indexOf('-');
                    //удалим лишний "-"
                    arifmeticSign(myText);
                    //запустим вычитание
                    Calculation calculation = new Calculation();
                    String result = calculation.Calc(myText);
                    //вернем убранный "-" для дальнейшей работы
                    myText = result + "-";
                    //итог выведем на экран
                    editText.setText(myText);
                }
            }
        });

        //кнопка умножения
        button_Mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myText.length() > 0) {
                    if (!(myText.charAt(myText.length() - 1) == 'x')) {
                        arifmeticSign(myText);
                        myText = myText + "x";
                        editText.setText(myText);
                    }
                }
                if (myText.length() > 0) {
                    int myPos = 0;
                    //если существует "x" найдем его позицию и присвоим myPos
                    if ((myText.indexOf('-') != -1) || (myText.indexOf('+') != -1) || (myText.indexOf('x') != -1) ||
                            (myText.indexOf('/') != -1)) myPos = (int) myText.indexOf('-');
                    //удалим лишний "x"
                    arifmeticSign(myText);
                    //запустим вычитание
                    Calculation calculation = new Calculation();
                    String result = calculation.Calc(myText);
                    //вернем убранный "x" для дальнейшей работы
                    myText = result + "x";
                    //итог выведем на экран
                    editText.setText(myText);
                }
            }
        });

        //кнопка деления
        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myText.length() > 0) {
                    if (!(myText.charAt(myText.length() - 1) == '/')) {
                        arifmeticSign(myText);
                        myText = myText + "/";
                        editText.setText(myText);
                    }
                }
                if (myText.length() > 0) {
                    int myPos = 0;
                    //если существует "/" найдем его позицию и присвоим myPos
                    if ((myText.indexOf('-') != -1) || (myText.indexOf('+') != -1) || (myText.indexOf('x') != -1) ||
                            (myText.indexOf('/') != -1)) myPos = (int) myText.indexOf('-');
                    //удалим лишний "/"
                    arifmeticSign(myText);
                    //запустим вычитание
                    Calculation calculation = new Calculation();
                    String result = calculation.Calc(myText);
                    //вернем убранный "/" для дальнейшей работы
                    myText = result + "/";
                    //итог выведем на экран
                    editText.setText(myText);
                }
            }
        });

        //кнопка равно
        button_Equl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myText.length() > 0) {
                    if (!(arifmeticSign(myText))) {
                        Calculation calculation = new Calculation();
                        String result = calculation.Calc(myText);
                        myText = result;
                    }
                    editText.setText(myText);
                }
            }
        });

        //кнопка очистки экрана
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myText = "0";
                editText.setText("");
            }
        });

        //кнопка удаления последнего символа
        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //удалим последний символ
                if (myText.length() > 0) {
                    myText = myText.substring(0, myText.length() - 1);
                    editText.setText(myText);
                }
            }
        });

        //кнопка процента
        button_Proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myText.length() > 0) {
                    if (myText.charAt(myText.length() - 1) != '%') {
                        myText = myText + "%";
                        editText.setText(myText);
                    }
                }
            }
        });

        //кнопка знак "+/-"
        button_Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myText.length() > 0) {
                    if (myText.charAt(0) == '-')
                        myText = myText.substring(1, myText.length());
                    else
                        myText = "-" + myText;
                }
                editText.setText(myText);
            }
        });

    }

    //удаление последнего арифм.знака---------------------------------------------------------------
    private boolean arifmeticSign(String text) {
        switch (text.charAt(text.length() - 1)) {
            case '+':
            case '-':
            case '/':
            case 'x':
                myText = myText.substring(0, myText.length() - 1);
                return true;
        }
        return false;
    }

    //проверка возможности установки "точки"--------------------------------------------------------
    private boolean isPossibleSetDot(String text) {
        //если "точки" еще нет, то можно ставить
        if (myText.indexOf('.') == -1) return true;
        //если точка есть, проверим где она, если до ариф.знака, то можно ставить новую
        if ((myText.lastIndexOf('.') != -1)) {
            //найдём позицию "точки"
            int posDot = myText.lastIndexOf('.');
            //посмотрим каждый символ текста
            for (int i = 0; i < text.length(); i++) {
                if ((text.charAt(i) == '+') || (text.charAt(i) == '-') || (text.charAt(i) == 'x') ||
                        (text.charAt(i) == '/')) {
                    //найдём позицю ариф.знака
                    int posSign = i;
                    if (posDot < posSign) return true;
                }
            }
        }
        return false;
    }

    //проверка возможности установки "0"------------------------------------------------------------
    private boolean isPossibleSetNull(String text) {
        int posDot = -1;
        int posNull = -1;
        int posSign = -1;
        //если ноль есть, проверим где он, если после ариф.знака, то ставить новый НЕЛЬЗЯ!
        if ((myText.lastIndexOf('0') != -1)) {
            //найдём позицию "нуля"
            posNull = myText.lastIndexOf('0');
            //посмотрим каждый символ текста
            for (int i = 0; i < text.length(); i++) {
                if ((text.charAt(i) == '+') || (text.charAt(i) == '-') || (text.charAt(i) == 'x') ||
                        (text.charAt(i) == '/'))
                    //найдём позицю ариф.знака
                    posSign = i;
            }
            if (posNull != posSign + 1) return true;

            //если точка существует
            if (text.indexOf('.') != -1) {
                //найдем последнюю позицию "точки"
                posDot = text.lastIndexOf('.');
                if (posSign < posDot) return true;

            }


            //если "точка" последний знак то 0 можно ставить
            if (text.charAt(text.length() - 1) == '.') return true;
        } else return true;
        return false;
    }


    //инициализируем все объекты на экране----------------------------------------------------------
    private void initViews() {
        button_0 = findViewById(R.id.btn0);
        button_Del = findViewById(R.id.btnDel);
        button_1 = findViewById(R.id.btn1);
        button_Proc = findViewById(R.id.btnProc);
        button_2 = findViewById(R.id.btn2);
        button_C = findViewById(R.id.btnC);
        button_3 = findViewById(R.id.btn3);
        button_Mult = findViewById(R.id.btn_x);
        button_4 = findViewById(R.id.btn4);
        button_Div = findViewById(R.id.btn_div);
        button_5 = findViewById(R.id.btn5);
        button_Summ = findViewById(R.id.btn_Plus);
        button_6 = findViewById(R.id.btn6);
        button_Ded = findViewById(R.id.btn_Minus);
        button_7 = findViewById(R.id.btn7);
        button_Equl = findViewById(R.id.btn_equals);
        button_8 = findViewById(R.id.btn8);
        button_Sign = findViewById(R.id.btnSign);
        button_9 = findViewById(R.id.btn9);
        button_Dot = findViewById(R.id.btnDot);

        btn_settings = findViewById(R.id.btn_settings);

        editText = findViewById(R.id.EditText);
        // switchTheme = findViewById(R.id.switchTheme);

    }
}