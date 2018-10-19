package com.example.gem.maboychart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

/**
 * Created by gem on 10/19/18.
 */

public class LineChartActivity extends AppCompatActivity implements OnChartValueSelectedListener, OnChartGestureListener {

  private static final String TAG = "LineChartActivity";

  private LineChart mChart;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.linechart_activity);

    mChart = (LineChart) findViewById(R.id.line_chart_view);

//    mChart.setOnChartGestureListener(this);
//    mChart.setOnChartValueSelectedListener(this);

    mChart.setDragEnabled(true);
    mChart.setScaleEnabled(false);

    ArrayList<Entry> yValues = new ArrayList<>();

    yValues.add(new Entry(0, 60f));
    yValues.add(new Entry(1, 50f));
    yValues.add(new Entry(2, 70f));
    yValues.add(new Entry(3, 30f));
    yValues.add(new Entry(4, 50f));
    yValues.add(new Entry(5, 60f));
    yValues.add(new Entry(6, 65f));

    LineDataSet set1 = new LineDataSet(yValues, "Data Set 1");

    set1.setFillAlpha(110);
    set1.setColor(Color.RED);
    set1.setLineWidth(3f);
    set1.setValueTextSize(10f);
    set1.setValueTextColor(Color.GREEN);

    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    dataSets.add(set1);

    LineData data = new LineData(dataSets);

    mChart.setData(data);


  }

  @Override
  public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

  }

  @Override
  public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

  }

  @Override
  public void onChartLongPressed(MotionEvent me) {

  }

  @Override
  public void onChartDoubleTapped(MotionEvent me) {

  }

  @Override
  public void onChartSingleTapped(MotionEvent me) {

  }

  @Override
  public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

  }

  @Override
  public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

  }

  @Override
  public void onChartTranslate(MotionEvent me, float dX, float dY) {

  }

  @Override
  public void onValueSelected(Entry e, Highlight h) {

  }

  @Override
  public void onNothingSelected() {

  }
}
