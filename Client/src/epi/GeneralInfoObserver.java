package epi;

public interface GeneralInfoObserver {
	public abstract void experimentListChange(int index, String value);
	public abstract void disable();
	public abstract void enable();
	public abstract void reset();
}
