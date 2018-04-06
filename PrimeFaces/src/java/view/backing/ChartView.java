/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.stream.IntStream;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Tomi
 */
@ManagedBean
public class ChartView {

    private LineChartModel chartModel;
    private static final int STEP = 10;
    private static final int MIN_X = 0;
    private static final int MAX_X = 360;
    private static final int MIN_Y = -1;
    private static final int MAX_Y = 1;

    public ChartView() {
        chartModel = new LineChartModel();
        chartModel.setTitle("Sinus i Cosinus");
        chartModel.setLegendPosition("e");
        chartModel.setZoom(true);

        LineChartSeries sinusSeries = new LineChartSeries("sinus");
        IntStream.iterate(0, n -> n + STEP).limit(MAX_X/STEP + 1)
                .forEach(v -> sinusSeries.set(v, Math.sin(Math.toRadians(v))));

        LineChartSeries cosinusSeries = new LineChartSeries("cosinus");
        IntStream.iterate(0, n -> n + STEP).limit(MAX_X/STEP + 1)
                .forEach(v -> cosinusSeries.set(v, Math.cos(Math.toRadians(v))));
        
        chartModel.addSeries(sinusSeries);
        chartModel.addSeries(cosinusSeries);
        
        Axis axisX = chartModel.getAxis(AxisType.X);
        axisX.setMax(MAX_X);
        axisX.setMin(MIN_X);
        
        Axis axisY = chartModel.getAxis(AxisType.Y);
        axisY.setMin(MIN_Y);
        axisY.setMax(MAX_Y);
    }

    /**
     * @return the chartModel
     */
    public LineChartModel getChartModel() {
        return chartModel;
    }

    /**
     * @param chartModel the chartModel to set
     */
    public void setChartModel(LineChartModel chartModel) {
        this.chartModel = chartModel;
    }
}
