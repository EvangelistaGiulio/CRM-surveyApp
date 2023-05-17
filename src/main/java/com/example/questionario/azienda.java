package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class azienda extends AppCompatActivity {
TextView tv_stip,tv_eta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azienda);
        tv_stip=findViewById(R.id.tv_stip);
        tv_eta=findViewById(R.id.tv_eta);

        BackgroundWorkerSel backgroundWorkerSelCitEta=new BackgroundWorkerSel(this);
        backgroundWorkerSelCitEta.execute(tv_stip,tv_eta);

        String[] zona={"", "Nord", "Centro", "Sud", "Isole"};
        BarChart mChart = (BarChart) findViewById(R.id.barChart);
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(false);
        mChart.getDescription().setEnabled(false);
        mChart.setDrawGridBackground(false);

        XAxis xaxis = mChart.getXAxis();
        xaxis.setDrawGridLines(false);
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setGranularity(1f);
        xaxis.setDrawLabels(true);
        xaxis.setDrawAxisLine(false);
        xaxis.setValueFormatter(new IndexAxisValueFormatter(zona));

        YAxis yAxisLeft = mChart.getAxisLeft();
        yAxisLeft.setEnabled(true);

        mChart.getAxisRight().setEnabled(false);

        Legend legend = mChart.getLegend();
        legend.setEnabled(false);

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();

        BarEntry entry1 = new BarEntry(1,8);
        BarEntry entry2 = new BarEntry(2,5);
        BarEntry entry3 = new BarEntry(3,3);
        BarEntry entry4 = new BarEntry(4,3);
        valueSet1.add(entry1);
        valueSet1.add(entry2);
        valueSet1.add(entry3);
        valueSet1.add(entry4);

        List<IBarDataSet> dataSets = new ArrayList<>();
        BarDataSet barDataSet = new BarDataSet(valueSet1, "");
        barDataSet.setColor(Color.YELLOW);
        barDataSet.setDrawValues(false);
        dataSets.add(barDataSet);

        BarData data = new BarData(dataSets);
        mChart.setData(data);
        mChart.invalidate();
        mChart.setDragEnabled(true);
        mChart.animateY(2000);
        mChart.getAxisLeft().setTextColor(Color.WHITE);
        mChart.getXAxis().setTextColor(Color.WHITE);
        mChart.setViewPortOffsets(60, 0, 50, 60);
        mChart.getDescription().setTextColor(Color.WHITE);


        PieChart pieChart= findViewById(R.id.pieChart);
        ArrayList<PieEntry> sesso = new ArrayList<>();
        sesso.add(new PieEntry(60,"Maschi"));
        sesso.add(new PieEntry(40,"Femmine"));

        PieDataSet pieDataSet=new PieDataSet(sesso,"Sesso");

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(16f);

        PieData pieData=new PieData(pieDataSet);
        pieData.setValueFormatter(new PercentFormatter(pieChart));

        pieChart.setData(pieData);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Sesso");
        pieChart.setHoleColor(Color.BLACK);
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.getLegend().setEnabled(false);
        pieChart.animate();

    }

    public void toCRM(View view) {
        Intent intent=new Intent(this,CRM.class);
        startActivity(intent);
    }
}