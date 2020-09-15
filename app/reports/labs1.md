# Цели
- Ознакомиться со средой разработки Android Studio
- Изучить основные принципы верстки layout с использованием View и ViewGroup
- Изучить основные возможности и свойства LinearLayout
- Изучить основные возможности и свойства ConstraintLayout

## Вариант 10

![](https://github.com/KarrokBeorna/Android_labs/blob/master/app/Pictures/labs1/var10_10.png)

![](https://github.com/KarrokBeorna/Android_labs/blob/master/app/Pictures/labs1/var10_19.png)

## Задача 1 - LinearLayout

__Листинг 1.1__

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <Space
            android:layout_width="match_parent"
            android:layout_height="150dp"/>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:text="150dp + 1/3 h"
            android:layout_weight="1"
            android:gravity="center" />

        <Button
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:text="1/3 h"
            android:layout_weight="1"/>

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:src="@drawable/ic_launcher_background"
            android:layout_weight="1"/>

    </LinearLayout>

__Листинг 1.2__

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:text="150dp + 1/3 h"
            android:layout_weight="1"
            android:layout_marginTop="150dp"
            android:gravity="center" />

        <Button
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:text="1/3 h"
            android:layout_weight="1"
            android:gravity="center"/>

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:src="@drawable/ic_launcher_background"
            android:layout_weight="1"/>

    </LinearLayout>

__Листинг 1.3__

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal">

        <LinearLayout
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:id="@+id/textView4"
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:gravity="center"
                android:text="TextView" />

            <Space
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"/>

            <Space
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"/>
        </LinearLayout>



        <LinearLayout
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <Space
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"/>

            <Button
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:text="Button" />

            <Space
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"/>
        </LinearLayout>

        <LinearLayout
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                app:srcCompat="@drawable/ic_launcher_background" />

            <Space
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"/>

            <Space
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"/>
        </LinearLayout>


    </LinearLayout>

- layout_weight - веса для заполнения пространства (в моих случаях ставил всегда
1, чтобы равномерно 3 объекта заполняли);
- gravity - расположение содержимого внутри объекта (для __TextView__ использовал,
чтобы текст был в центре);
- layout_gravity - расположение объекта внутри layout;
- orientation - ориентация - горизонтальная и вертикальная;
- layout_height - высота объекта (данное поле нельзя убрать);
- layout_width - длина объекта (данное поле нельзя убрать).

Как мне кажется я максимально уменьшил код, убрав все лишние тэги и атрибуты.

### Вывод
LinearLayout достаточно прост в использовании, он попросту выравнивает объекты
по горизонтали или вертикали. Но я бы всё-таки предпочел ConstraintLayout,
который мы будем использовать во второй задаче.

## Задача 2 - ConstraintLayout

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

__Листинг 2.2__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/textView5"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:gravity="center"
            android:text="TextView"
            app:layout_constraintBottom_toTopOf="@+id/button5"
            app:layout_constraintEnd_toStartOf="@+id/button5"
            app:layout_constraintHorizontal_weight="1"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <Button
            android:id="@+id/button5"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:text="Button"
            app:layout_constraintBottom_toBottomOf="@id/guideline8"
            app:layout_constraintEnd_toStartOf="@id/imageView6"
            app:layout_constraintHorizontal_weight="1"
            app:layout_constraintStart_toEndOf="@id/textView5"
            app:layout_constraintTop_toBottomOf="@id/guideline9" />

        <ImageView
            android:id="@+id/imageView6"
            android:layout_width="0dp"
            android:layout_height="0dp"
            app:layout_constraintBottom_toTopOf="@+id/button5"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_weight="1"
            app:layout_constraintStart_toEndOf="@+id/button5"
            app:layout_constraintTop_toTopOf="parent"
            app:srcCompat="@drawable/ic_launcher_background" />

        <androidx.constraintlayout.widget.Guideline
            android:id="@+id/guideline9"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal"
            app:layout_constraintGuide_percent="0.3333333" />

        <androidx.constraintlayout.widget.Guideline
            android:id="@+id/guideline8"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal"
            app:layout_constraintGuide_percent="0.6666666" />
    </androidx.constraintlayout.widget.ConstraintLayout>

- layout_constraintDimensionRatio - отношение сторон;
- layout_constraintHorizontal_weight - тот же вес, что и в LinearLayout только для горизонтали;
- layout_constraintVertical_weight - вес для вертикали.

### Вывод
Ничего необычного в данном пункте мы не получили, просто заменили LinearLayout
на ConstraintLayout. Их главное отличие лишь в том, что мы можем устанавливать
интересные связи между объектами, что значительно упрощает расположение объектов
на экране.

## Задача 3 - ConstraintLayout

![](https://github.com/KarrokBeorna/Android_labs/blob/master/app/Pictures/labs1/var10_10_test3.png)

__Листинг 3.1__

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <androidx.constraintlayout.widget.ConstraintLayout
            android:id="@+id/CL"
            android:layout_width="0dp"
            android:layout_height="0dp"
            app:layout_constraintDimensionRatio="1"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">

            <androidx.constraintlayout.widget.Guideline
                android:id="@+id/guideline6"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:orientation="horizontal"
                app:layout_constraintGuide_percent="0.2" />

            <androidx.constraintlayout.widget.Guideline
                android:id="@+id/guideline7"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:orientation="horizontal"
                app:layout_constraintGuide_percent="0.4"/>

            <androidx.constraintlayout.widget.Guideline
                android:id="@+id/guideline11"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:orientation="horizontal"
                app:layout_constraintGuide_percent="0.6"/>

            <androidx.constraintlayout.widget.Guideline
                android:id="@+id/guideline8"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:orientation="horizontal"
                app:layout_constraintGuide_percent="0.8" />

            <androidx.constraintlayout.widget.Guideline
                android:id="@+id/guideline3"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:orientation="vertical"
                app:layout_constraintGuide_percent="0.2"/>

            <androidx.constraintlayout.widget.Guideline
                android:id="@+id/guideline4"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:orientation="vertical"
                app:layout_constraintGuide_percent="0.4"/>

            <androidx.constraintlayout.widget.Guideline
                android:id="@+id/guideline5"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:orientation="vertical"
                app:layout_constraintGuide_percent="0.6" />

            <CheckBox
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:text="CheckBox"
                app:layout_constraintEnd_toEndOf="@id/CL"
                app:layout_constraintTop_toTopOf="@id/CL"
                app:layout_constraintBottom_toTopOf="@id/guideline6"
                app:layout_constraintStart_toEndOf="@id/guideline5"/>

            <ImageView
                android:layout_width="0dp"
                android:layout_height="0dp"
                app:layout_constraintBottom_toTopOf="@+id/guideline11"
                app:layout_constraintEnd_toEndOf="@id/CL"
                app:layout_constraintStart_toStartOf="@+id/guideline5"
                app:layout_constraintTop_toTopOf="@+id/guideline7"
                app:srcCompat="@drawable/ic_launcher_background" />

            <TextView
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:text="TextView"
                app:layout_constraintBottom_toTopOf="@+id/guideline7"
                app:layout_constraintEnd_toStartOf="@+id/guideline4"
                app:layout_constraintStart_toStartOf="@id/CL"
                app:layout_constraintTop_toTopOf="@+id/guideline6" />

            <Button
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:text="Button"
                app:layout_constraintBottom_toTopOf="@+id/guideline7"
                app:layout_constraintEnd_toStartOf="@+id/guideline5"
                app:layout_constraintStart_toStartOf="@+id/guideline4"
                app:layout_constraintTop_toTopOf="@id/CL" />

            <Switch
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:text="Switch"
                app:layout_constraintBottom_toTopOf="@+id/guideline8"
                app:layout_constraintEnd_toStartOf="@+id/guideline4"
                app:layout_constraintStart_toStartOf="@+id/guideline3"
                app:layout_constraintTop_toTopOf="@+id/guideline7" />

            <ProgressBar
                android:layout_width="0dp"
                android:layout_height="0dp"
                app:layout_constraintBottom_toTopOf="@+id/guideline8"
                app:layout_constraintEnd_toStartOf="@+id/guideline5"
                app:layout_constraintStart_toStartOf="@+id/guideline4"
                app:layout_constraintTop_toTopOf="@+id/guideline7" />

            <SeekBar
                android:layout_width="0dp"
                android:layout_height="0dp"
                app:layout_constraintBottom_toBottomOf="@id/CL"
                app:layout_constraintEnd_toEndOf="@id/CL"
                app:layout_constraintStart_toEndOf="@id/guideline5"
                app:layout_constraintTop_toBottomOf="@id/guideline8"/>

        </androidx.constraintlayout.widget.ConstraintLayout>

    </androidx.constraintlayout.widget.ConstraintLayout>

Эта задача оказалась чуть-чуть интереснее предыдущих, так как здесь мы... просто
писали больше строчек! Всё однообразно: вставили объект, добавили guideline и
связали. Вот и вся задача.

## Выводы
Для начала опишу своё «вытаптывание снега в AS».
Сначала, конечно же, быстро скачал и установил. Затем потыкался в телефоне, в
поисках отладки по USB. Нашел, запустил example с подключенным телефоном и…
Просто установился пример. Полазил в res – посмотрел картинки и потыкался
в .xml-файлике. Создал виртуальное устройство – докачал 700 мб в окне System Image…  
запустил и-и-и… понял, что больше виртуалку не буду использовать, потому что
работает слишком медленно. Наиболее применимые бинды уже были использованы
на 1 и 2 курсе в Идее, поэтому по одному разу их нажал и пошел дальше. Собственно,
потыкал MainActivity и AndroidManifest.
После всего этого пошел создавать директорию и .xml-файлы в кол-ве 6 шт. Под конец
работы выяснилось, что у нас поменялись варианты аз-за неправильной сортировки,
поэтому пошел делать работу во второй раз (сделал буквально за 20 минут).

Теперь переходим к части картинок, Github'a и-и-и... Markdown. Каким-то волшебным
образом я умудрился поломать весь свой проект: отображение вкладки Android
отображало все файлы, как и сама вкладка Project; app больше не был с зеленым
кружочком, некоторый синтаксис в .xml-файлах стал подчеркиваться красным. После
таких страшных картин я принял решение создавать новый проект и просто скопировать
туда ранее созданные .xml-файлы. А Markwodn это вообще ужас какой-то. Как по мне
легче держать 2 окна рядом - с отчетом и кодом, а не вот это вот чудо, которое
очень неудобно без графического интерфейса Word'a...

Вывод: не стоит мудрить, всё делай через AS... Про редакторы .md лучше вообще
промолчу ;). Ну, получилось много боли и соплей, но отчет сделан.
