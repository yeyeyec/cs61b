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
		for (double t=0;t<=T;t=t+dt){
			double[] xForces = new double[planets.length];
		    double[] yForces = new double[planets.length];
		    for (int i=0;i<planets.length;i=i+1){
		    	xForces[i] = planets[i].calcNetForceExertedByX(planets);
		    	yForces[i] = planets[i].calcNetForceExertedByY(planets);
		    }
		    for (int i=0;i<planets.length;i=i+1){
		    	planets[i].update(dt,xForces[i],yForces[i]);
		    }
		    StdDraw.picture(0,0,"images/starfield.jpg");
		    for (int i=0;i<planets.length;i=i+1){
		    	planets[i].draw();
		    }
		    StdDraw.show();
		    StdDraw.pause(10);
			
		}
		StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i=0;i<planets.length;i=i+1){
        	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);

        }

	}
}