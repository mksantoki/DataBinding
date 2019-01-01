#DataBinding

- Here you’ll just add those inside android scope in build.gradle


```
android{
   dataBinding {
      enabled true
   }
}
```
- And then wrap all your layouts with layout tag so it’s the root tag everywhere
```
<layout>
   <data>
      <variable
       name="movie"
       type="com.myhexaville.Movie"/>
   </data>

   <TextView
    ...
    android:text="@{movie.name}"/>

</layouyt>
```

- Now that’s the next level, here you need to do some changes though. Replace default setContentView with this
```
@Override
protected void onCreate(Bundle savedInstanceState) {
   ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

}
```
- As you see there’s some ActivityMainBinding class – this class is generated for your layouts, it’s based on layout name converted to camel case adding Binding at the end. It happens when you wrap your layout with layout tag. If you have layout called layout.xml – you’d have LayoutBinding class generated

- Now to access any of your views you just use

```
binding.textView
```

- Set data to data model
```
binding.setMovie(new Movie(...));
```

- Load Image using data binding
```
<layout>
   <data>
      <variable
       name="movie"
       type="com.myhexaville.Movie"/>
   </data>

   <ImageView
    ...
    app:imageUrl="@{movie.imageUrl}"/>

</layouyt>
```
- Auto method will call with image view and url

```
     * Image url.
     *
     * @param imageView the image view
     * @param url       the url
     */
    @BindingAdapter("app:imageUrl")
    public static void imageUrl(ImageView imageView, String url) {
      Glide.with(imageView).load(url).into(imageView);
    }
```

- Advantage
With findViewById you’d have 40 lines of code, with Butterknife – 20, with DataBinding – 2. Two lines! Data Binding is obvious winner here

