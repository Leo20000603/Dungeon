public class UserLocation {

	public int location;
	private boolean locationChanged;
	
	public UserLocation() {
		location = 0;
		locationChanged = false;
	}
	
	public boolean getLocationChanged() {
		return locationChanged;
	}
	
	public void toggleLocationChanged(boolean b) {
		locationChanged = b;
	}
	
	public void changeLocation(int i) {
		location = i;
	}
	public int getFloor(){
		return location;
	}
}

