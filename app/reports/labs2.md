# Цели
- Ознакомиться с жизненным циклом Activity
- Изучить основные возможности и свойства alternative resources

## Вариант 10

## Задача 1 - Activity

Жизненный цикл решил сразу смотреть на примере continuewatch.

- В самом начале, при запуске приложения, у нас вызываются 3 метода: onCreate, onStart, onResume.
- При повороте экрана: onPause - onSaveInstanceState - onStop - onDestroy - onCreate - onStart - onRestoreInstanceState - onResume
- При нажатии на Overview: onPause - onSaveInstanceState - onStop - onRestart - onStart - onResume
- При нажатии на Home: аналогично Overview
- При выключении экрана и последующем включении: аналогично Overview
- При звонке: onPause - onSaveInstanceState - onStop - onDestroy - onCreate - onStart - onRestoreInstanceState - onResume - onPause - __onSaveInstanceState - onStop - onDestroy - onCreate - onStart - onRestoreInstanceState - onResume__ (последние 7 при завершении разговора)
- При просмотре полученного сообщения: onPause - onSaveInstanceState - onStop - onRestart - onStart - onResume
- При выключении устройства: onPause - onSaveInstanceState - onStop

__Листинг 1.1__

    package com.example.android_labs

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import kotlinx.android.synthetic.main.continuewatch.*

    val SECONDS_EL = "seconds_el"

    class Continuewatch : AppCompatActivity() {
        var secondsElapsed: Int = 0
        var onTheScreen = false

        var backgroundThread = Thread {
            while (true) {
                Thread.sleep(1000)
                if (onTheScreen) {
                    textSecondsElapsed.post {
                        textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
                    }
                }
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.continuewatch)
            backgroundThread.start()
            Log.d("MyLifecycle", "onCreate")
        }

        override fun onRestart() {
            super.onRestart()
            Log.d("MyLifecycle", "onRestart")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d("MyLifecycle", "onDestroy")
        }

        override fun onPause() {
            onTheScreen = false
            super.onPause()
            Log.d("MyLifecycle", "onPause")
        }

        override fun onStart() {
            super.onStart()
            Log.d("MyLifecycle", "onStart")
        }

        override fun onResume() {
            onTheScreen = true
            super.onResume()
            Log.d("MyLifecycle", "onResume")
        }

        override fun onStop() {
            super.onStop()
            Log.d("MyLifecycle", "onStop")
        }

        override fun onSaveInstanceState(outState: Bundle) {
            outState.putInt(SECONDS_EL, secondsElapsed)
            super.onSaveInstanceState(outState)
            Log.d("MyLifecycle", "onSaveInstanceState")
        }

        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
            secondsElapsed = savedInstanceState.getInt(SECONDS_EL)
            super.onRestoreInstanceState(savedInstanceState)
            Log.d("MyLifecycle", "onRestoreInstanceState")
        }
    }

__Листинг 1.2__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".Continuewatch">

        <TextView
            android:id="@+id/textSecondsElapsed"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

    </androidx.constraintlayout.widget.ConstraintLayout>

__Листинг 1.3__

    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="com.example.android_labs">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".Continuewatch"
                tools:ignore="WrongManifestParent">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

## Задача 2 - Alternative Resources

Продемонстрируйте работу альтернативного ресурса - __touchscreen type__.

2 вида: finger - сенсорный и notouch - не сенсорный ;)

Я использовал xml-файл с прошлой лабораторной и просто приписал кнопке действие по сокрытию картинки. Демонстрацию провел на устройстве.

__Листинг 2.1__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <androidx.constraintlayout.widget.Guideline
            android:id="@+id/guideline2"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_constraintGuide_begin="150dp"
            android:orientation="horizontal"/>

        <ImageView
            android:id="@+id/imageView7"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            app:layout_constraintBottom_toTopOf="@+id/button6"
            app:layout_constraintTop_toBottomOf="@+id/guideline2"
            app:srcCompat="@drawable/ic_launcher_background"/>

        <Button
            android:id="@+id/button6"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:text="Button"
            android:onClick="invis"
            app:layout_constraintBottom_toTopOf="@+id/textView6"
            app:layout_constraintTop_toBottomOf="@+id/imageView7"/>

        <TextView
            android:id="@+id/textView6"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:gravity="center"
            android:text="TextView"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/button6"/>

    </androidx.constraintlayout.widget.ConstraintLayout>

Переписал немного __MainActivity__:
__Листинг 2.2__

    package com.example.android_labs

    import android.os.Bundle
    import android.view.View
    import android.widget.ImageView
    import androidx.appcompat.app.AppCompatActivity
    import kotlinx.android.synthetic.main.task2_1.*

    class MainActivity: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.task2_1)
        }

        var count = 0

        fun invis(view: View) {
            val iv = findViewById<ImageView>(R.id.imageView7)
            if (count % 2 == 1) {
                iv.visibility = View.GONE
                count++
            } else {
                imageView7.visibility = View.VISIBLE
                count++
            }
        }
    }

Заодно проверил, как работает findViewById и просто обращение к ImageView.

Самый первый пример, который пришел мне в голову - Clash of Clans. Это мобильная стратегия, где выпускать юнитов на поле боя необходимо нажатием на само поле.
Особенностью является то, что мы также могли бы выпускать и с помощью мыши, например, в эмуляторе BlueStacks, но с помощью сенсора мы можем использовать сразу все 10 пальцев, если это поддерживает ваше устройство. Такая функция называется - multi-touch.  

## Задача 3 - Best-matching resource

__Конфигурация устройства:__
LOCALE_LANG: en
LOCALE_REGION: rFR
SCREEN_SIZE: xlarge
SCREEN_ASPECT: notlong
ROUND_SCREEN: round
ORIENTATION: land
UI_MODE: watch
NIGHT_MODE: notnight
PIXEL_DENSITY: mdpi
TOUCH: notouch
PRIMARY_INPUT: nokeys
NAV_KEYS: nonav
PLATFORM_VER: v26

__Конфигурация ресурсов:__
(default)
long-round-port
rFR-notlong-round-notnight-nodpi-v25
notlong-land-xxxhdpi
long-ldpi-finger
fr-notlong-port-qwerty-v25
long-port
round-desk-xxhdpi-v26
rFR-notlong-nokeys-v27
large-port-vrheadset-12key
fr-rUS-watch-finger

- Убираем 2 строки с языками fr

(default)
long-round-port
rFR-notlong-round-notnight-nodpi-v25
notlong-land-xxxhdpi
long-ldpi-finger
__~~fr-notlong-port-qwerty-v25~~__
long-port
round-desk-xxhdpi-v26
rFR-notlong-nokeys-v27
large-port-vrheadset-12key
__~~fr-rUS-watch-finger~~__

- Убираем 2 строки с регионами rFR, так как нельзя писать только регион

(default)
long-round-port
__~~rFR-notlong-round-notnight-nodpi-v25~~__
notlong-land-xxxhdpi
long-ldpi-finger
long-port
round-desk-xxhdpi-v26
__~~rFR-notlong-nokeys-v27~~__
large-port-vrheadset-12key

- Смотрим на размер экрана и убираем лишнюю строку

(default)
long-round-port
notlong-land-xxxhdpi
long-ldpi-finger
long-port
round-desk-xxhdpi-v26
__~~large-port-vrheadset-12key~~__

- Смотрим на формат экрана

(default)
__~~long-round-port~~__
__~~notlong-land-xxxhdpi~~__
__~~long-ldpi-finger~~__
__~~long-port~~__
round-desk-xxhdpi-v26

- Мы нашли __notlong__, но плотность пикселей не xxxhdpi, поэтому убрали и его

- Осталось 2 варианта, и вариант с round тоже не подходит, поэтому оставляем __default__.

## Задача 4 - Сохранение состояние Activity

Ошибки, которые исправил:

- Убрал атрибут text у TextView, чтобы не отображалось "Hello World"
- Добавил глобальную переменную для сохранения секунд при перезапуске
- Добавил остановку и продолжение счета при onPause и onResume

Как и сказано в самом задании, мы должны были использовать методы onSaveInstanceState и onRestoreInstanceState, которые записывают текущее состояние в глобальную переменную и берут из неё число при возобновлении.

## Вывод

Затраченное время на выполнение работы и составление отчета - 6 часов.

Так как я совместил выполнение 1 и 4 пунктов, то время немного сэкономилось.
Первое задание само по себе легкое, но при попытке запуска устройства на телефоне, я не видел сообщений в Logcat, поэтому спустя минут 20 я решил выполнять на эмуляторе (спасибо, у меня вылетел синий экран с надписью "Код ошибки: MEMORY_MANAGEMENT"). Задание наконец закончил спустя полтора часа, при этом добавив все недостающие элементы для Task4.

Сидел и долго думал, как мне вообще что-то написать для touchscreen type атрибута. В итоге просто решил дать действие кнопке, чтобы она отображала и скрывала картинку ;)

На Task3 потратил минут 30, но зато сразу вносил всё в отчет.
