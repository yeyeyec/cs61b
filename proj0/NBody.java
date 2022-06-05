public class NBody{
	public static String imageToDraw = "images/starfield.jpg";
	public static double readRadius(String t){
		In in = new In(t);
		int Planets = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}
	public static Planet[] readPlanets(String t){
		In in = new In(t);
		int num = in.readInt();
		Planet[] planets = new Planet[num];

		in.readDouble();
		for (int i = 0;i<num;i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xP,yP,xV,yV,m,img);

		}
		return planets;

	}
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double uniRadius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-uniRadius, uniRadius);
		StdDraw.clear();
		StdDraw.picture(0,0,imageToDraw);
		for (Planet s: planets){
			s.draw();
		}
		StdDraw.enableDoubleBuffering();
        for(double t=0;t<=T;t+=dt){
            //创造xForce和YForce数组
            double[] xForce=new double[planets.length];
            double[] yForce=new double[planets.length];
            //计算netForce
            for (int i=0;i<planets.length;i++){
                xForce[i]=planets[i].calcNetForceExertedByX(planets);
                yForce[i]=planets[i].calcNetForceExertedByY(planets);
            }
            //更新每个星体 update
            for (int i=0;i<planets.length;i++){
                planets[i].update(dt,xForce[i],yForce[i]);
            }
            //绘制背景图
            StdDraw.picture(0,0,imageToDraw);
            //绘制每个星体的图片
            for (int i=0;i<planets.length;i++){
                planets[i].draw();
            }
            //显示屏幕外的缓冲区（双缓冲时动画在屏幕外）
            StdDraw.show();
            //暂停10毫秒
            StdDraw.pause(10);
            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", uniRadius);
            for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
		
	}
}