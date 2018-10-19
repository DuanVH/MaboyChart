package com.example.gem.maboychart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

/**
 * Created by gem on 10/19/18.
 */

public class PieChartActivity extends AppCompatActivity {

  PieChart pieChart;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.piechart_activity);

    pieChart = (PieChart) findViewById(R.id.pie_chart_view);


    pieChart.setUsePercentValues(true);
    pieChart.getDescription().setEnabled(false);
    pieChart.setExtraOffsets(5, 10, 5, 5);

    pieChart.setDragDecelerationFrictionCoef(0.95f);  // toc do quay cua bieu do

//    pieChart.setDrawHoleEnabled(false);  // co rong o giua hinh tron hay khong?
    pieChart.setDrawHoleEnabled(true);
    pieChart.setHoleColor(Color.WHITE);
    pieChart.setTransparentCircleRadius(31f);  // transference cua duong vien o giua

    ArrayList<PieEntry> yValues = new ArrayList<>();

    yValues.add(new PieEntry(34f, "A"));
    yValues.add(new PieEntry(23f, "B"));
    yValues.add(new PieEntry(14f, "C"));
    yValues.add(new PieEntry(35, "D"));
    yValues.add(new PieEntry(40, "E"));
    yValues.add(new PieEntry(23, "F"));


    /*Show toast khi bieu do xuat hien*/
    Description description = new Description();
    description.setText("Ahihi Do hoi ngoc!");
    description.setTextSize(15);
    pieChart.setDescription(description);

    pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

    PieDataSet dataSet = new PieDataSet(yValues, "Alphabet");
    dataSet.setSliceSpace(1f);  // do rong (width) cua duong ke giau cac mien
    dataSet.setSelectionShift(5f);
    dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

    PieData data = new PieData(dataSet);
    data.setValueTextSize(10f);
    data.setValueTextColor(Color.YELLOW);

    pieChart.setData(data);

  }
}
