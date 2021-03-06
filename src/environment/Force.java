package environment;

import java.util.List;
import jboxGlue.PhysicalObject;
import object.Mass;


/**
 * Abstract force class
 * 
 */
public abstract class Force {

    public boolean valid = true;

    /**
     * Applies force to masses only in a list of physical objects
     * 
     */
    public void setForce (List<PhysicalObject> objects) {
        for (PhysicalObject object : objects) {
            if (object instanceof Mass && valid) {
                setForce(object);
            }
        }
    }

    /**
     * Applies force to list of physical objects
     */
    public abstract void setForce (PhysicalObject object);

    /**
     * Debugging method that prints out whether or not a force is on
     */
    public void toggleValid () {
        valid = !valid;

        if (valid) {
            System.out.println(getClass().getSimpleName() + " On.");
        }
        else {
            System.out.println(getClass().getSimpleName() + " Off.");
        }
    }

    /**
     * check the force is on or not
     * 
     * @return valid
     */
    public boolean isValid () {
        return valid;
    }
}
