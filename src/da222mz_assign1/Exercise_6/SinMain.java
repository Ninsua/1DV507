package da222mz_assign1.Exercise_6;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SinMain {

	public static void main(String[] args) {
		double[] xList = new double[500];
		double[] yList = new double[500];
		xList[0] = 0;
		
		//Add 
		for (int i = 1;i<xList.length;i++) {
			xList[i] = xList[i-1]+Math.PI*2/xList.length;
		}
		
		for (int i = 0;i<yList.length && i<xList.length;i++) {
			yList[i] = (1 + xList[i]/Math.PI)*Math.cos(xList[i])*Math.cos(40*xList[i]);
		}
		
		XYChart chart = new XYChartBuilder().width(800).height(600).build();
		
	    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
	    chart.getStyler().setMarkerSize(3);
		
	    chart.addSeries("Sine for 0 <= x <= 2*pi", xList, yList);
	    new SwingWrapper<>(chart).displayChart();
		
	}

}
