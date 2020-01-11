package com.example.android.diabetes;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Health_tips_Fragment extends Fragment {


    private TextView header;
    private TextView texts;
    View view;
    String[] x;
    String[] y;
    List<String> z;
    int postion;
    private TextView header1;
    private TextView text1;
    private TextView header2;
    private TextView text2;
    private TextView header3;
    private TextView text3;
    private TextView header4;
    private TextView text4;
    private TextView header5;
    private TextView text5;
    private TextView header6;
    private TextView text6;
    private TextView header7;
    private TextView text7;
    private TextView header8;
    private TextView text8;
    private TextView header9;
    private TextView text9;
    private TextView header10;
    private TextView text10;
    private Spinner healthSpinner;

    public Health_tips_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_health_tips_, container, false);
        initView();
        SpinnerHealthTips();
        ChooseTips();
        return view;
    }

    private void initView() {
        z = new ArrayList<>();
        header1 = (TextView) view.findViewById(R.id.header1);
        text1 = (TextView) view.findViewById(R.id.text1);
        header2 = (TextView) view.findViewById(R.id.header2);
        text2 = (TextView) view.findViewById(R.id.text2);
        header3 = (TextView) view.findViewById(R.id.header3);
        text3 = (TextView) view.findViewById(R.id.text3);
        header4 = (TextView) view.findViewById(R.id.header4);
        text4 = (TextView) view.findViewById(R.id.text4);
        header5 = (TextView) view.findViewById(R.id.header5);
        text5 = (TextView) view.findViewById(R.id.text5);
        header6 = (TextView) view.findViewById(R.id.header6);
        text6 = (TextView) view.findViewById(R.id.text6);
        header7 = (TextView) view.findViewById(R.id.header7);
        text7 = (TextView) view.findViewById(R.id.text7);
        header8 = (TextView) view.findViewById(R.id.header8);
        text8 = (TextView) view.findViewById(R.id.text8);
        header9 = (TextView) view.findViewById(R.id.header9);
        text9 = (TextView) view.findViewById(R.id.text9);
        header10 = (TextView) view.findViewById(R.id.header10);
        text10 = (TextView) view.findViewById(R.id.text10);
        healthSpinner = (Spinner) view.findViewById(R.id.health_spinner);
    }

    private void SpinnerHealthTips() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.health_tips, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        healthSpinner.setAdapter(adapter);
        healthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              postion=position;
              ChooseTips();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
     void ChooseTips(){
        switch (postion){
         case 0:Obesity();
         break;
            case 1:High_blood_pressure();
            break;
            case 2:Low_blood_pressure();
                break;
            case 3:High_Glucose();
                break;
            case 4:Urination();
                break;

     }

    }
    void Obesity() {
        x = getResources().getStringArray(R.array.obesity);
        y = getResources().getStringArray(R.array.obesity_texts);
        header1.setText(x[0]);
        header2.setText(x[1]);
        header3.setText(x[2]);
        header4.setText(x[3]);
        header5.setText(x[4]);
        header6.setText(x[5]);
        header7.setText(x[6]);

        header8.setText("");
        header9.setText("");
        header10.setText("");

        text1.setText(y[0]);
        text2.setText(y[1]);
        text3.setText(y[2]);
        text4.setText(y[3]);
        text5.setText(y[4]);
        text6.setText(y[5]);
        text7.setText(y[6]);
        text8.setText("");
        text9.setText("");
        text10.setText("");


    }

    void High_blood_pressure() {
        x = getResources().getStringArray(R.array.High_blood_pressure);
        z.add("Exercise is one of the best things you can do to lower high blood pressure.\n" +
                "Regular exercise helps make your heart stronger and more efficient at pumping blood, which lowers the pressure in your arteries.\n" +
                "In fact, 150 minutes of moderate exercise, such as walking, or 75 minutes of vigorous exercise, such as running, per week can help lower blood pressure and improve your heart health.\n" +
                "Whats more, doing even more exercise reduces your blood pressure even further, according to the National Walkers Health Study.\n" +
                "Bottom Line: Walking just 30 minutes a day can help lower your blood pressure. More exercise helps reduce it even further.");
        z.add("Salt intake is high around the world. In large part, this is due to processed and prepared foods.\n" +
                "For this reason, many public health efforts are aimed at lowering salt in the food industry.\n" +
                "In many studies, salt has been linked to high blood pressure and heart events, like stroke.\n" +
                "However, more recent research indicates that the relationship between sodium and high blood pressure is less clear.\n" +
                "One reason for this may be genetic differences in how people process sodium. About half of people with high blood pressure and a quarter of people with normal levels seem to have a sensitivity to salt.\n" +
                "If you already have high blood pressure, its worth cutting back your sodium intake to see if it makes a difference. Swap out processed foods with fresh ones and try seasoning with herbs and spices, rather than salt.\n" +
                "Bottom Line: Most guidelines for lowering blood pressure recommend lowering sodium intake. However, that recommendation might make the most sense for people who are salt-sensitive");

        z.add("Drinking alcohol can raise blood pressure. In fact, alcohol is linked to 16% of high blood pressure cases around the world.\n" +
                "While some research has suggested that low-to-moderate amounts of alcohol may protect the heart, those benefits may be offset by negative effects.\n" +
                "In the US, moderate alcohol consumption is defined as no more than one drink a day for women and two for men.If you drink more than that, cut back.\n" +
                "Bottom Line: Drinking alcohol in any quantity may raise your blood pressure. Limit your drinking to no more than one drink a day for women, two for men.");
        z.add("Potassium is an important mineral.\n" +
                "It helps your body get rid of sodium and ease pressure on your blood vessels.\n" +
                "Modern diets have increased most people's sodium intake while decreasing potassium intake ().\n" +
                "To get a better balance of potassium to sodium in your diet, focus on eating fewer processed foods and more fresh, whole foods.\n" +
                "Foods that are particularly high in potassium include:\n" +
                "•\tVegetables, especially leafy greens, tomatoes, potatoes and sweet potatoes\n" +
                "•\tFruit, including melons, bananas, avocados, oranges and apricots\n" +
                "•\tDairy, such as milk and yogurt\n" +
                "•\tTuna and salmon\n" +
                "•\tNuts and seeds\n" +
                "•\tBeans\n" +
                "Bottom Line: Eating fresh fruits and vegetables, which are rich in potassium, can help lower blood pressure.\n");
        z.add("If you've ever downed a cup of coffee before you've had your blood pressure taken, you'll know that caffeine causes an instant boost.\n" +
                "However, there's not a lot of evidence to suggest that drinking caffeine regularly can cause a lasting increase.\n" +
                "In fact, people who drink caffeinated coffee and tea tend to have a lower risk of heart disease, including high blood pressure, than those who don't.\n" +
                "Caffeine may have a stronger effect on people who don't consume it regularly.\n" +
                "If you suspect you're caffeine-sensitive, cut back to see if it lowers your blood pressure.\n" +
                "Bottom Line: Caffeine can cause a short-term spike in blood pressure, although for many people it does not cause a lasting increase.\n");
        z.add("Stress is a key driver of high blood pressure.\n" +
                "When you're chronically stressed, your body is in a constant fight-or-flight mode. On a physical level, that means a faster heart rate and constricted blood vessels.\n" +
                "When you experience stress, you might also be more likely to engage in other behaviors, such as drinking alcohol or eating unhealthy food, that can negatively affect blood pressure.\n" +
                "Several studies have explored how reducing stress can help lower blood pressure. Here are two evidence-based tips to try:\n" +
                "•\tListen to soothing music: Calming music can help relax your nervous system. Research has shown it's an effective complement to other blood pressure therapies.\n" +
                "•\tWork less: Working a lot, and stressful work situations in general, are linked to high blood pressure.\n" +
                "Bottom Line: Chronic stress can contribute to high blood pressure. Finding ways to manage stress can help.\n");

        z.add("Here's a piece of advice you can really get behind.\n" +
                "While eating massive amounts of chocolate probably won't help your heart, small amounts may.\n" +
                "That's because dark chocolate and cocoa powder are rich in flavonoids, plant compounds that cause blood vessels to dilate.\n" +
                "A review of studies found that flavonoid-rich cocoa improved several markers of heart health over the short term, including lowering blood pressure.\n" +
                "For the strongest effects, use non-alkalized cocoa powder, which is especially high in flavonoids and has no added sugars.\n" +
                "Bottom Line: Dark chocolate and cocoa powder contain plant compounds that help relax blood vessels, lowering blood pressure.\n");
        z.add("If you're overweight, losing weight can make a big difference for your heart health.\n" +
                "According to a 2016 study, losing 5% of your body mass could significantly lower high blood pressure.\n" +
                "In previous studies, losing 17 pounds (7.7 kg) was linked to lowering systolic blood pressure by 8.5 mm Hg and diastolic blood pressure by 6.5 mm Hg.\n" +
                "To put that in perspective, a healthy reading should be less than 120/80 mm Hg.\n" +
                "The effect is even greater when weight loss is paired with exercise.\n" +
                "Losing weight can help your blood vessels do a better job of expanding and contracting, making it easier for the left ventricle of the heart to pump blood.\n" +
                "Bottom Line: Losing weight can significantly lower high blood pressure. This effect is even greater when you exercise.\n");
        z.add("Among the many reasons to quit smoking is that the habit is a strong risk factor for heart disease.\n" +
                "Every puff of cigarette smoke causes a slight, temporary increase in blood pressure. The chemicals in tobacco are also known to damage blood vessels.\n" +
                "Surprisingly, studies haven't found a conclusive link between smoking and high blood pressure. Perhaps this is because smokers develop a tolerance over time.\n" +
                "Still, since both smoking and high blood pressure raise the risk of heart disease, quitting smoking can help reverse that risk.\n" +
                "Bottom Line: There's conflicting research about smoking and high blood pressure, but what is clear is that both increase the risk of heart disease.\n");
        z.add("There's a growing body of research showing a link between added sugar and high blood pressure.\n" +
                "In the Framingham Women's Health Study, women who drank even one soda per day had higher levels than those who drank less than one soda per day.\n" +
                "Another study found that having one less sugar-sweetened beverage per day was linked to lower blood pressure.\n" +
                "And it's not just sugar - all refined carbs, such as the kind found in white flour, convert rapidly to sugar in your bloodstream and may cause problems.\n" +
                "Some studies have shown that low-carb diets may also help reduce blood pressure.\n" +
                "One study on people undergoing statin therapy found that those who went on a six-week, carb-restricted diet saw a greater improvement in blood pressure and other heart disease markers than people not on a diet.\n" +
                "Bottom Line: Refined carbs, especially sugar, may raise blood pressure. Some studies have shown that low-carb diets may help reduce your levels.\n");

        header1.setText(x[0]);
        header2.setText(x[1]);
        header3.setText(x[2]);
        header4.setText(x[3]);
        header5.setText(x[4]);
        header6.setText(x[5]);
        header7.setText(x[6]);
        header8.setText(x[7]);
        header9.setText(x[8]);
        header10.setText(x[9]);

        text1.setText(z.get(0));
        text2.setText(z.get(1));
        text3.setText(z.get(2));
        text4.setText(z.get(3));
        text5.setText(z.get(4));
        text6.setText(z.get(5));
        text7.setText(z.get(6));
        text8.setText(z.get(7));
        text9.setText(z.get(8));
        text10.setText(z.get(9));

    }

    void Low_blood_pressure() {
        x = getResources().getStringArray(R.array.Low_blood_pressure);
        y = getResources().getStringArray(R.array.low_blood_texts);
        header1.setText(x[0]);
        header2.setText(x[1]);
        header3.setText(x[2]);
        header4.setText(x[3]);
        header5.setText(x[4]);
        header6.setText(x[5]);
        header7.setText(x[6]);
        header8.setText(x[7]);
        header9.setText(x[8]);

        header10.setText("");

        text1.setText(y[0]);
        text2.setText(y[1]);
        text3.setText(y[2]);
        text4.setText(y[3]);
        text5.setText(y[4]);
        text6.setText(y[5]);
        text7.setText(y[6]);
        text8.setText(y[7]);
        text9.setText(y[8]);

        text10.setText("");

    }

    void High_Glucose() {
        x = getResources().getStringArray(R.array.High_glucose);
        y = getResources().getStringArray(R.array.high_glucose_texts);
        header1.setText(x[0]);
        header2.setText(x[1]);
        header3.setText(x[2]);
        header4.setText(x[3]);
        header5.setText(x[4]);
        header6.setText(x[5]);
        header7.setText(x[6]);
        header8.setText(x[7]);
        header9.setText(x[8]);
        header10.setText(x[9]);

        text1.setText(y[0]);
        text2.setText(y[1]);
        text3.setText(y[2]);
        text4.setText(y[3]);
        text5.setText(y[4]);
        text6.setText(y[5]);
        text7.setText(y[6]);
        text8.setText(y[7]);
        text9.setText(y[8]);
        text10.setText(y[9]);

    }

    void Urination() {
        x = getResources().getStringArray(R.array.Urination);
        y = getResources().getStringArray(R.array.urination_texts);
        header1.setText(x[0]);
        header2.setText(x[1]);
        header3.setText(x[2]);
        header4.setText(x[3]);
        header5.setText(x[4]);
        header6.setText(x[5]);
        header7.setText(x[6]);
        header8.setText(x[7]);

        header9.setText("");
        header10.setText("");

        text1.setText(y[0]);
        text2.setText(y[1]);
        text3.setText(y[2]);
        text4.setText(y[3]);
        text5.setText(y[4]);
        text6.setText(y[5]);
        text7.setText(y[6]);
        text8.setText(y[7]);

        text9.setText("");
        text10.setText("");
    }
}
