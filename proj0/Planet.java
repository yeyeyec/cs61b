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
	public Planet(Planet b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}
	public double calcDistance(Planet b){
		double deltax = this.xxPos - b.xxPos;
		double deltay = this.yyPos - b.yyPos;
		double r = Math.sqrt(deltax*deltax + deltay*deltay);
		return r;
	}
	public double calcForceExertedBy(Planet b){
		double r1 = calcDistance(b);
		double F = (G* this.mass * b.mass)/r1*r1;
		return F;
	}
	public double calcForceExertedByX(Planet b){
		double ForceX = (this.calcForceExertedBy(b)*(b.xxPos - this.xxPos))/this.calcDistance(b);
		return ForceX;
	}
	public double calcForceExertedByY(Planet b){
		double ForceY =  (this.calcForceExertedBy(b)*(b.yyPos - this.yyPos))/this.calcDistance(b);
		return ForceY;
	}
	public double calcNetForceExertedByX(Planet[] allplanets){
		double NetForceX = 0;
		for (Planet s:allplanets){
			if (!this.equals(s)){
				NetForceX = NetForceX + this.calcForceExertedByX(s);
			}
		}
		return NetForceX;
	}
	public double calcNetForceExertedByY(Planet[] allplanets){
		double NetForceY = 0;
		for (Planet s:allplanets){
			if (!this.equals(s)){
				NetForceY = NetForceY + this.calcForceExertedByY(s);
			}
		}
		return NetForceY;
	}
	public void update(double dt,double fX,double fY){
		double ax = fX/this.mass;
		double ay = fY/this.mass;
		this.xxVel = this.xxVel + dt*ax;
		this.yyVel = this.yyVel + dt*ay;
		this.xxPos = this.xxPos + dt*this.xxVel;
		this.yyPos = this.yyPos + dt*this.yyVel;

	}
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	}



}