public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet b){
		double deltax = this.xxPos - b.xxPos;
		double deltay = this.yyPos - b.yyPos;
		return Math.sqrt(deltax*deltax + deltay*deltay);
	}
	public double calcForceExertedBy(Planet b){
		return (G* this.mass * b.mass)/(this.calcDistance(b)*this.calcDistance(b));
	}
	public double calcForceExertedByX(Planet b){
		double ForceX = (this.calcForceExertedBy(b)*(this.xxPos - b.xxPos))/this.calcDistance(b);
		if (ForceX <0){
			return -ForceX;
		}
		return ForceX;
	}
	public double calcForceExertedByY(Planet b){
		double ForceY =  (this.calcForceExertedBy(b)*(this.yyPos - b.yyPos))/this.calcDistance(b);
		if (ForceY <0){
			return -ForceY;
		}
		return ForceY;
	}
	public double calcNetForceExertedByX(Planet[] allplanets){
		double NetForceX = 0;
		for (Planet s:allplanets){
			NetForceX = NetForceX+(this.calcForceExertedBy(s)*(this.xxPos - s.xxPos))/this.calcDistance(s);
		}if (NetForceX <0){
			return -NetForceX;
		}
		return NetForceX;
	}
	public double calcNetForceExertedByY(Planet[] allplanets){
		double NetForceY = 0;
		for (Planet s: allplanets){
			NetForceY = NetForceY+(this.calcForceExertedBy(s)*(this.yyPos - s.yyPos))/this.calcDistance(s);
		}if (NetForceY <0){
			return -NetForceY;
		}
		return NetForceY;
	}
	public void update(double dt,double fX,double fY){
		double ax = fX/this.mass;
		double ay = fY/this.mass;
		xxVel = xxVel + dt*ax;
		yyVel = yyVel + dt*ay;
		xxPos = xxPos + dt*xxVel;
		yyPos = yyPos + dt*yyVel;

	}
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}



}