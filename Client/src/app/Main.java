package app;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.tweenengine.Tween;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Main {
	public static void main(String[] args) {
			
		Tween.registerAccessor(ThePanel.class, new ThePanel.Accessor());

		Model model;
		model = new Model();
		new Controller(model, new View());
		
		SLAnimator.start();
		
	}
}
