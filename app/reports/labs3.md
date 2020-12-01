# Цели

- Ознакомиться с методом обработки жизненного цикла activity/fragment при помощи Lifecycle-Aware компонентов
- Изучить основные возможности навигации внутри приложения: создание новых activity, navigation graph

## Вариант 10

## Задача 1 - Обработка жизненного цикла с помощью Lifecycle-Aware компонентов

Проделал все 8 шагов. Интересное из прочитанного:
- можно не писать методы в самой Activity, а делать это с помощью __OnLifecycleEvent__
- закрепил информацию, полученную во время лекций, по поводу LifecycleOwner, ViewModel, LiveData

## Задача 2 - Навигация (startActivityForResult)

Создаем 3 Activity и к ним 3 xml-файла.

__Листинг 2.1 - Activity1__

    package com.example.android_labs

    import android.content.Intent
    import android.os.Bundle
    import android.view.View
    import androidx.appcompat.app.AppCompatActivity

    class Activity1: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity1)
        }

        fun toSecond(view: View) {
            startActivity(Intent("com.example.android_labs.Activity2"))
        }
    }

__Листинг 2.2 - Activity2__

    package com.example.android_labs

    import android.app.Activity
    import android.content.Intent
    import android.os.Bundle
    import android.view.View
    import androidx.appcompat.app.AppCompatActivity

    class Activity2: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity2)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == SEC_ACT) {
                if (resultCode == Activity.RESULT_OK) {
                    finish()
                }
            }
        }

        val SEC_ACT = 0

        fun toFirst(view: View) {
            finish()
        }
        fun toThird(view: View) {
            val intent = Intent(this, Activity3::class.java)
            startActivityForResult(intent, SEC_ACT)
        }
    }

__Листинг 2.3 - Activity3__

    package com.example.android_labs

    import android.app.Activity
    import android.os.Bundle
    import android.view.View
    import androidx.appcompat.app.AppCompatActivity

    class Activity3: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity3)
        }

        fun toSecondOnThird(view: View) {
            finish()
        }

        fun toFirstOnThird(view: View) {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

__Листинг 2.4 - activity1.xml__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.drawerlayout.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true">


    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="50dp"
            android:layout_gravity="center|top"
            android:text="to second"
            android:onClick="toSecond" />

    </FrameLayout>

    <com.google.android.material.navigation.NavigationView
        android:id="@+id/nav_view"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:fitsSystemWindows="true" >

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="@string/Task3" />
    </com.google.android.material.navigation.NavigationView>

    </androidx.drawerlayout.widget.DrawerLayout>

__Листинг 2.5 - activity2.xml__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/drawer_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true">


        <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <Button
                android:id="@+id/button2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="toFirst"
                android:text="to first"
                android:layout_marginTop="50dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />

            <Button
                android:id="@+id/button3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="toThird"
                android:layout_marginTop="50dp"
                android:text="to third"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/button2" />
        </androidx.constraintlayout.widget.ConstraintLayout>

        <com.google.android.material.navigation.NavigationView
            android:id="@+id/nav_view"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:fitsSystemWindows="true" >

            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:gravity="center"
                android:text="@string/Task3" />
        </com.google.android.material.navigation.NavigationView>

    </androidx.drawerlayout.widget.DrawerLayout>

__Листинг 2.6 - activity3.xml__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/drawer_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true">

        <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <Button
                android:id="@+id/button2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="50dp"
                android:onClick="toFirstOnThird"
                android:text="to first"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />

            <Button
                android:id="@+id/button3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="50dp"
                android:onClick="toSecondOnThird"
                android:text="to second"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/button2" />
        </androidx.constraintlayout.widget.ConstraintLayout>

        <com.google.android.material.navigation.NavigationView
            android:id="@+id/nav_view"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:fitsSystemWindows="true" >

            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:gravity="center"
                android:text="@string/Task3" />
        </com.google.android.material.navigation.NavigationView>

    </androidx.drawerlayout.widget.DrawerLayout>

Прописываем все Activty в Манифесте. Если не прописать, то приложение попросту закроется, когда мы попытаемся перейти на какой-либо экран.

__Листинг 2.7 - AndroidManifest__

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
            <activity android:name=".Activity1"
                tools:ignore="WrongManifestParent">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
            <activity android:name=".Activity2">
                <intent-filter>
                    <action android:name="com.example.android_labs.Activity2" />
                    <category android:name="android.intent.category.DEFAULT" />
                </intent-filter>
            </activity>
            <activity android:name=".Activity3">
                <intent-filter>
                    <action android:name="com.example.android_labs.Activity3" />
                    <category android:name="android.intent.category.DEFAULT" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

## Задача 3 - Навигация (флаги Intent/атрибуты Activity)

Переписали немного Activity, а точнее методы для переходов.
Использовал лишь один флаг для перехода с третьей на первую деятельность, чтобы все деятельности выше первой были закрыты.

__Листинг 3.1 - методы переходов__

    fun toSecond(view: View) {
        startActivity(Intent("com.example.android_labs.Activity2"))
    }

    fun toFirst(view: View) {
        finish()
    }

    fun toThird(view: View) {
        startActivity(Intent("com.example.android_labs.Activity3"))
    }

    fun toFirstOnThird(view: View) {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }

    fun toSecondOnThird(view: View) {
        finish()
    }

## Задача 4 - Навигация (флаги Intent/атрибуты Activity) - расширенная

Чтобы не нагромождать отчет, листинги лучше показать в самой Android Studio.
Исследованные флаги:
- __FLAG_ACTIVITY_REORDER_TO_FRONT__ - рассмотрел на примере вызова первого экрана с четвертой деятельности. Как результат мы получили стек не из трёх элементов - 1-4-1, а из 2 - 4-1, при этом корневой экран переместился на вторую позицию. Если мы вызовем 1-4-1-4-1, то получим 4-4-1, что не очень приятно, так как 2 одинаковых деятельности расположены рядом друг с другом, но я не знаю, как это исправить. К тому же подобную ситуацию я замечал в приложении "VK", когда при нажатии на Back я оказывался в одном и том же экране по несколько раз.
Если мы после 1-4-1 вызовем 2, а затем опять 1, то получим не 1, а всё те же 4-1, потому что флаг в вызове toFirst_t4 очищает лишь верхние деятельности.
- __FLAG_ACTIVITY_NO_HISTORY__ - рассмотрел на примере вызова второго экрана с 4 деятельности. Если мы нажмем на "TO THIRD" то перейдем на третий экран, однако из стека второй экран удалится, и теперь он будет состоять из 1-4-3.

Оба эти флага можно легко продемонстрировать на устройстве.

Больше всего мне понравился именно флаг изменения стека деятельностей. Можно интересные вещи с ним делать. Единственное, чего я не проверил, если у нас в стеке, допустим, те же 4-4-1, и у нас будет вызываться 4 экран с флагом перемещения вверх, то какая деятельность переместится: одна верхняя, обе деятельности или они объединятся в одну и переместятся так?

## Задача 5 - Навигация (Fragments, Navigation Graph)

Очень долго разбирался с тем, что от меня хотят - примерно часа 4.
На самом же деле всё достаточно просто.

1. Создаем навигационный граф в res/navigation
2. Создаем новую ActivityMain, которую прописываем в Манифесте
3. Создаем 4 фрагмента - наши бывшие AppCompatActivity
4. К фрагментам и деятельности создаем 5 xml-файлов, после чего используем *__Convert to data binding layout__* для их копий - получаем в сумме 10 xml-файлов с нашими кнопками переходов
5. В навигационном графе соединяем все наши фрагменты, как в Задаче 4
6. Во фрагментах добавляем каждой кнопке действие через setOnClickListener, причем используем кнопку не из обычного xml-файла, а именно из DataBinding (предварительно импортируем)
7. В xml-файле main прописываем наше боковое меню, в других xml-файлах оно не потребуется

__Листинг 5.1 - ActivityMain__

    package com.example.android_labs.labs3_task5

    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import androidx.navigation.fragment.NavHostFragment
    import androidx.navigation.ui.setupWithNavController
    import com.example.android_labs.R
    import com.example.android_labs.databinding.MainActivityLabs3Task5Binding
    import com.google.android.material.navigation.NavigationView

    class ActivityMain: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val binding = MainActivityLabs3Task5Binding.inflate(layoutInflater)
            setContentView(binding.root)

            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
            val navController = navHostFragment.navController

            val sideBar = findViewById<NavigationView>(R.id.nav_view)
            sideBar?.setupWithNavController(navController)
        }
    }

__Листинг 5.2 - task5_first__

    package com.example.android_labs.labs3_task5

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.navigation.findNavController
    import com.example.android_labs.R
    import com.example.android_labs.databinding.Activity1Labs3Task5Binding

    class task5_first : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding = Activity1Labs3Task5Binding.inflate(layoutInflater)

            binding.toSecond.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_first_to_task5_second)
            }
            binding.toFourth.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_first_to_task5_fourth)
            }
            return binding.root
        }

    }

__Листинг 5.3 - Task5_second__

    package com.example.android_labs.labs3_task5

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.navigation.findNavController
    import com.example.android_labs.R
    import com.example.android_labs.databinding.Activity2Labs3Task5Binding

    class Task5_second : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding = Activity2Labs3Task5Binding.inflate(layoutInflater)

            binding.toFirst.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_second_to_task5_first)
            }
            binding.toThird.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_second_to_task5_third)
            }
            return binding.root
        }

    }

__Листинг 5.4 - Task5_third__

    package com.example.android_labs.labs3_task5

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.navigation.findNavController
    import com.example.android_labs.R
    import com.example.android_labs.databinding.Activity3Labs3Task5Binding

    class Task5_third : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding = Activity3Labs3Task5Binding.inflate(layoutInflater)

            binding.toFirst.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_third_to_task5_first)
            }
            binding.toSecond.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_third_to_task5_second)
            }
            return binding.root
        }

    }

__Листинг 5.5 - Task5_fourth__

    package com.example.android_labs.labs3_task5

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.navigation.findNavController
    import com.example.android_labs.R
    import com.example.android_labs.databinding.Activity4Labs3Task5Binding

    class Task5_fourth : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding = Activity4Labs3Task5Binding.inflate(layoutInflater)

            binding.toFirst.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_fourth_to_task5_first)
            }
            binding.toSecond.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_fourth_to_task5_second)
            }
            binding.toThird.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_task5_fourth_to_task5_third)
            }
            return binding.root
        }

    }

__Листинг 5.6 - task5_main.xml__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.drawerlayout.widget.DrawerLayout
        android:id="@+id/drawer_1"
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        tools:openDrawer="start">

        <androidx.fragment.app.FragmentContainerView
            android:name="androidx.navigation.fragment.NavHostFragment"
            android:id="@+id/navigation_host"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:defaultNavHost="true"
            app:navGraph="@navigation/nav_graph" />

        <com.google.android.material.navigation.NavigationView
            android:id="@+id/nav_view"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:fitsSystemWindows="true"
            app:menu="@menu/drawer_menu">

            <TextView
                android:id="@+id/textView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:text="@string/Task3" />
        </com.google.android.material.navigation.NavigationView>

    </androidx.drawerlayout.widget.DrawerLayout>

Переходы работают приятнее, чем со startActivity, однако в стеке хранятся абсолютно все переходы. То есть если мы будем нажимать 2-3-2-3-2-3-2-3, то при нажатии на Back мы пройдемся по всем этим экранам, чтобы дойти до Home. Возможно, есть решение, но я не знаю об этом, поэтому предпочел бы использовать флаги Intent, вместо всей этой навигации.

## Выводы

Суммарная затрата времени - 15 часов с составлением отчета:
- Task1 - полтора часа - просто почитал, потыкался
- Task2 - 2 часа - долго думал над startActivityForResult и onActivityResult
- Task3 - полтора часа - не хотел создавать новые файлы, поэтому просто закомментировал то, что было в Task2 и написал новое рядом, однако много времени потратил на startActivity(Intent("action из Манифеста")) - с этим не работал флаг так, как мне нужно было, поэтому избавился от этого кода и стал просто писать через новую переменную
- Task4 - 3 часа - добавил лишь один экран и опять застопорился на startActivity, однако в этот раз еще добавление новых Activity в Манифест вызвало некоторые проблемы. Много раз приложение закрывалось, пока опять не переписал startActivity через новые переменные
- Task5 - 7 часов с учетом создания отчета - очень долго разбирался с DataBinding, затем долго создавал файлы и редактировал их. Пытался смотреть Udacity, однако понял, что легче просто загуглить, как применять этот граф. Жаль, что я это сделал лишь спустя 2 часа страданий.

Что я точно усвоил - нельзя стирать в категориях DEFAULT всем деятельностям. Всегда следует прописывать каждую Activity в Манифесте. Ресурсы сильно захламляются с навигационным графом, превращая левое окно Project в помойку, поэтому лучше (и легче!!!) использовать флаги Intent.
