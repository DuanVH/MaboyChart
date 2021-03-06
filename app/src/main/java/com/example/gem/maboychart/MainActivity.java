package com.example.gem.maboychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {

  private CombinedChart mChart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
  }

  private void initViews() {
    mChart = findViewById(R.id.chart_view);
    mChart.getDescription().setEnabled(false);
    mChart.setBackgroundColor(Color.WHITE);
    mChart.setDrawGridBackground(false);
    mChart.setDrawBarShadow(false);
    mChart.setHighlightFullBarEnabled(false);
    mChart.setOnChartValueSelectedListener(this);

    YAxis rightAxis = mChart.getAxisRight();
    rightAxis.setDrawGridLines(false);
    rightAxis.setAxisMinimum(0f);

    YAxis leftAxis = mChart.getAxisLeft();
    leftAxis.setDrawGridLines(false);
    leftAxis.setAxisMinimum(0f);

    final List<String> xLabel = new ArrayList<>();
    xLabel.add("Jan");
    xLabel.add("Feb");
    xLabel.add("Mar");
    xLabel.add("Apr");
    xLabel.add("May");
    xLabel.add("Jun");
    xLabel.add("Jul");
    xLabel.add("Aug");
    xLabel.add("Sep");
    xLabel.add("Oct");
    xLabel.add("Nov");
    xLabel.add("Dec");

    XAxis xAxis = mChart.getXAxis();
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    xAxis.setAxisMinimum(0f);
    xAxis.setGranularity(1f);
    xAxis.setValueFormatter(new IAxisValueFormatter() {
      @Override
      public String getFormattedValue(float value, AxisBase axis) {
        return xLabel.get((int) value % xLabel.size());
      }
    });

    CombinedData data = new CombinedData();
    LineData lineDatas = new LineData();
    lineDatas.addDataSet((ILineDataSet) dataChart());

    data.setData(lineDatas);


    xAxis.setAxisMinimum(data.getXMax() + 0.25f);

    mChart.setData(data);
//    mChart.invalidate();
  }

  private static DataSet dataChart() {
    LineData d = new LineData();
    int[] data = new int[]{1, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 9};

    ArrayList<Entry> entries = new ArrayList<>();

    for (int i = 0; i < 12; i++) {
      entries.add(new Entry(i, data[i]));
    }

    LineDataSet set = new LineDataSet(entries, "Request Ots approved");
    set.setColor(Color.GREEN);
    set.setLineWidth(2.5f);
    set.setCircleColor(Color.GREEN);
    set.setCircleRadius(5f);
    set.setFillColor(Color.GREEN);
    set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
    set.setDrawValues(true);
    set.setValueTextSize(10f);
    set.setValueTextColor(Color.GREEN);

    set.setAxisDependency(YAxis.AxisDependency.LEFT);
    d.addDataSet(set);

    return set;
  }

  @Override
  public void onValueSelected(Entry e, Highlight h) {
    Toast.makeText(this, "Value: "
        + e.getY()
        + ", index: "
        + h.getX()
        + ", DataSet index: "
        + h.getDataSetIndex(), Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onNothingSelected() {

  }
}
