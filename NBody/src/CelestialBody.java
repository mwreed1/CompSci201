

/**
 * Celestial Body class for NBody
 * @author Margaret Reed
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();
	}
	/**
	 * returns x position value for the body
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	/**
	 * returns y position value for the body
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	/**
	 * returns x velocity value for the body
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	/**
	 * returns mass value for the body
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	/**
	 * returns the file name for the body
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double dx = b.getX() - myXPos;
		double dy = b.getY() - myYPos;
		double dist = Math.sqrt(dx*dx + dy*dy);
		return dist;
	}
	/**
	 * returns force exerted by another body
	 * @param b the other body
	 */
	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		final double gravConst = 6.67*1e-11;
		double distSq = calcDistance(b) * calcDistance(b);
		double force = (gravConst * myMass * b.getMass()) / distSq;
		return force;
	}
	/**
	 * returns force exerted by x from another body
	 * @param b the other body
	 */
	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		double dx = b.getX() - myXPos;
		double dist = calcDistance(b);
		double fx = (calcForceExertedBy(b) * dx) / dist;
		return fx;
	}
	/**
	 * returns force exerted by y from another body
	 * @param b the other body
	 */
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		double dy = b.getY() - myYPos;
		double dist = calcDistance(b);
		double fy = (calcForceExertedBy(b) * dy) / dist;
		return fy;
	}
	/**
	 * returns net force exerted by x from all other bodies
	 * @param bodies array of other bodies
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double netForceX = 0.0;
		for(CelestialBody b : bodies) {
			if(! b.equals(this)) {
				netForceX += calcForceExertedByX(b);
			}
		}
		return netForceX;
	}
	/**
	 * returns net force exerted by y from all other bodies
	 * @param bodies array of other bodies
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double netForceY = 0.0;
		for(CelestialBody b : bodies) {
			if (!b.equals(this)) {
				netForceY += calcForceExertedByY(b);
			}
		}
		return netForceY;
	}
	/**
	 * updates position and velocity values for the body
	 * @param deltaT and xforce and yforce
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double ax = xforce / myMass;
		double ay = yforce / myMass;
		double nvx = myXVel + deltaT * ax;
		double nvy = myYVel + deltaT * ay;
		double nx = myXPos + (deltaT * nvx);
		double ny = myYPos + (deltaT * nvy);
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}
	/**
	 * draws simulation
	 */
	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos, myYPos, "images/" + myFileName);
	}
}
