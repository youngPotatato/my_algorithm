public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public static final double G = 6.67 * Math.pow(10,-11);

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass  = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance (Planet p) {
        return Math.sqrt((p.xxPos - xxPos) * (p.xxPos - xxPos) + (p.yyPos - yyPos) * (p.yyPos - yyPos));
    }

    public double calcForceExertedByX (Planet p) {
       double r2 = this.calcDistance(p) * this.calcDistance(p);
       double f  = G * mass * p.mass / r2;
       return f*(p.xxPos - xxPos)/this.calcDistance(p);
    }

    public double calcForceExertedByY (Planet p) {
        double r2 = this.calcDistance(p) * this.calcDistance(p);
        double f  = G * mass * p.mass / r2;
        return f*(p.yyPos - yyPos)/this.calcDistance(p);
    }

    public double calcForceExertedBy (Planet p) {
        double r2 = this.calcDistance(p) * this.calcDistance(p);
        double f  = G * mass * p.mass / r2;
        return f;
    }

    public double calcNetForceExertedByX (Planet[] pa) {
        double f = 0.0;
        for (Planet pp : pa) {
            if(this.equals(pp)) {
            }else {
                    f += calcForceExertedByX(pp);
            }
        }
        return f;
    }

    public double calcNetForceExertedByY (Planet[] pa) {
        double f = 0.0;
        for (Planet pp : pa) {
            if(this.equals(pp)) {
            }else {
                f += calcForceExertedByY(pp);
            }
        }
        return f;
    }

    public void update (double dt, double fx, double fy) {
        double ax = fx/mass;
        double ay = fy/mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
}
