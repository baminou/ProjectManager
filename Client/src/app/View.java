package app;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.slidinglayout.SLConfig;
import aurelienribon.slidinglayout.SLKeyframe;
import aurelienribon.slidinglayout.SLPanel;
import aurelienribon.slidinglayout.SLSide;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import controller.GeneralInfoController;
import controller.GenericController;
import controller.IlluminaController;
import controller.MicroarrayController;
import controller.PCRController;
import controller.SequencingController;
import java.awt.Font;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final SLPanel panel = new SLPanel();
	private final JPanel _imgPanel = new JPanel();
	private final ThePanel p1;
	private final ThePanel p2;
	private final ThePanel p3;
	private final ThePanel p4;
	private final ThePanel p5;
	private final ThePanel p6;
	private final ThePanel2 p7 = new ThePanel2("7", getClass().getClassLoader().getResourceAsStream("epigenetics.jpg"));
	private final SLConfig mainCfg, p1Cfg, p2Cfg, p3Cfg, p4Cfg, p5Cfg, p6Cfg, p7Cfg;
	private int current_panel = 2;
	private final JMenuBar _mainMenuBar = new JMenuBar();
	private final JMenu _fileMenu = new JMenu("File");
	private final JMenuItem _exitMenuBtn = new JMenuItem("Exit");
	private final JLabel _serverLbl = new JLabel(" ");
	private final JMenuItem _conventionMenuItem = new JMenuItem("Convention");
	private final JMenu _toolsMenu = new JMenu("Tools");
	private final JMenuItem _createProjectBtn = new JMenuItem("Create Project");
	private final JMenuItem _helpMenuBtn = new JMenuItem("?");

	public JMenuItem get_createProjectBtn() {
		return _createProjectBtn;
	}

	public JMenuBar get_mainMenuBar() {
		return _mainMenuBar;
	}

	public JMenu get_fileMenu() {
		return _fileMenu;
	}

	public JMenuItem get_exitMenuBtn() {
		return _exitMenuBtn;
	}

	public View() {
		p1 = new ThePanel("1", GeneralInfoController.getInstance().get_view());
		p2 = new ThePanel("2", new GenericController().get_view());
		p3 = new ThePanel("3", new IlluminaController().get_view());
		p4 = new ThePanel("4", new PCRController().get_view());
		p5 = new ThePanel("5", new SequencingController().get_view());
		p6 = new ThePanel("6", new MicroarrayController().get_view());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Project Manager 2.0");
		//setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		p2.setBackground(new Color(59, 89, 152));

		p2.setAction(p2Action);
		p3.setAction(p3Action);
		p4.setAction(p4Action);
		p5.setAction(p5Action);
		p6.setAction(p6Action);
		p7.setAction(p7Action);
		
		mainCfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).row(0f).col(1f)
			.beginGrid(0, 0)
				.row(1f).col(1f)
				.place(0, 0, p1)
			.endGrid()
			.beginGrid(0, 1)
				.row(1f).col(1f)
				.place(0, 0, p7)
			.endGrid()
			.beginGrid(0, 1)
				.row(1f).col(0f)
				.place(0, 0, p2)
			.endGrid()
			.beginGrid(0, 1)
				.row(1f).col(0f)
				.place(0, 0, p3)
			.endGrid()
			.beginGrid(0, 1)
				.row(1f).col(0f)
				.place(0, 0, p4)
			.endGrid()
			.beginGrid(0, 1)
				.row(1f).col(0f)
				.place(0, 0, p5)
			.endGrid()
			.beginGrid(0, 1)
				.row(1f).col(0f)
				.place(0, 0, p6)
			.endGrid();
		

		p1Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).row(0f).col(1f)
			.place(0, 0, p1);

		p2Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).row(0f).col(1f)
			.place(0, 1, p2)
			.place(0, 0, p1);

		p3Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).row(0f).col(1f)
			.place(0, 1, p3)
			.place(0, 0, p1);

		p4Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).row(0f).col(1f)
			.place(0, 1, p4)
			.place(0, 0, p1);
		
		p5Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).row(0f).col(1f)
			.place(0, 1, p5)
			.place(0, 0, p1);
		
		p6Cfg = new SLConfig(panel)
			.gap(10,10)
			.row(1f).col(2f).row(0f).col(1f)
			.place(0, 1, p6)
			.place(0, 0, p1);
		
		p7Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).row(0f).col(1f)
			.place(0, 1, p7)
			.place(0, 0, p1);
		
		
		p1.add(_mainMenuBar, BorderLayout.NORTH);
		_fileMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		
		
		_mainMenuBar.add(_fileMenu);
		_exitMenuBtn.setFont(new Font("Arial", Font.PLAIN, 12));
		
		
		_fileMenu.add(_exitMenuBtn);
		_toolsMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_mainMenuBar.add(_toolsMenu);
		_conventionMenuItem.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_toolsMenu.add(_conventionMenuItem);
		_toolsMenu.add(_createProjectBtn);
		_createProjectBtn.setFont(new Font("Arial", Font.PLAIN, 12));
		_toolsMenu.add(_archiveMenuItem);
		_archiveMenuItem.setFont(new Font("Arial", Font.PLAIN, 12));
		_helpMenuBtn.setToolTipText("Help");
		_helpMenuBtn.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_mainMenuBar.add(_helpMenuBtn);
		_serverLbl.setText("Zoidberg");
		_serverLbl.setBackground(Color.DARK_GRAY);
		_serverLbl.setForeground(Color.WHITE);
		
		p1.add(_serverLbl, BorderLayout.SOUTH);
		
		panel.setTweenManager(SLAnimator.createTweenManager());
		panel.initialize(mainCfg);
		
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public JPanel get_imgPanel() {
		return _imgPanel;
	}

	public ThePanel2 getp7() {
		return p7;
	}

	public SLConfig getp7Cfg() {
		return p7Cfg;
	}

	public Runnable getReset() {
		return reset;
	}

	public Runnable getGo_to_img_panel() {
		return go_to_img_panel;
	}

	public Runnable getGo_to_affy_action() {
		return go_to_affy_action;
	}

	public Runnable getGo_to_illumina_action() {
		return go_to_illumina_action;
	}

	public Runnable getGo_to_seq_action() {
		return go_to_seq_action;
	}

	public Runnable getGo_to_pcr_action() {
		return go_to_pcr_action;
	}

	public Runnable getp7Action() {
		return p7Action;
	}

	public final Runnable reset = new Runnable() {@Override public void run(){
		panel.createTransition()
		.push(new SLKeyframe(p7Cfg, 0.9f)
			)
		.play();
	current_panel = 6;
	}};
	
	public final Runnable go_to_img_panel = new Runnable() {@Override public void run(){
		panel.createTransition()
		.push(new SLKeyframe(p7Cfg, 0.9f)
			)
		.play();
	current_panel = 6;
	}};
	
	public final Runnable go_to_affy_action = new Runnable() {@Override public void run(){
		panel.createTransition()
		.push(new SLKeyframe(p2Cfg, 0.9f)
			)
		.play();
	current_panel = 2;
	}};
	
	public final Runnable go_to_microarray_action = new Runnable() {@Override public void run(){
		panel.createTransition()
		.push(new SLKeyframe(p6Cfg, 0.9f)
			)
		.play();
	current_panel = 2;
	}};
	
	public final Runnable go_to_illumina_action = new Runnable() {@Override public void run(){
		panel.createTransition()
		.push(new SLKeyframe(p3Cfg, 0.5f)
			)
		.play();
	current_panel = 3;
	}};
	
	public final Runnable go_to_seq_action = new Runnable() {@Override public void run(){
		panel.createTransition()
		.push(new SLKeyframe(p5Cfg, 0.5f))
		.play();
	current_panel = 5;
	}};
	
	public final Runnable go_to_pcr_action = new Runnable() {@Override public void run(){
		panel.createTransition()
		.push(new SLKeyframe(p4Cfg, 0.5f))
		.play();
	current_panel = 4;
	}};
	
	private final Runnable p2Action = new Runnable() {@Override public void run() {
		panel.createTransition()
			.push(new SLKeyframe(p3Cfg, 0.5f)
				.setEndSide(SLSide.RIGHT,  p2))
			.play();
		current_panel++;
	}};

	private final Runnable p3Action = new Runnable() {@Override public void run() {
		panel.createTransition()
			.push(new SLKeyframe(p4Cfg, 0.5f)
				.setEndSide(SLSide.RIGHT, p3))
			.play();
		current_panel++;
	}};

	private final Runnable p4Action = new Runnable() {@Override public void run() {
		panel.createTransition()
			.push(new SLKeyframe(p5Cfg, 0.5f)
				.setEndSide(SLSide.RIGHT, p4))
			.play();
		current_panel++;
	}};
	
	private final Runnable p5Action = new Runnable() {@Override public void run() {
		panel.createTransition()
			.push(new SLKeyframe(p6Cfg, 0.5f)
				.setEndSide(SLSide.RIGHT, p5))
			.play();
		current_panel++;
	}};
	
	private final Runnable p6Action = new Runnable() {@Override public void run() {
		panel.createTransition()
			.push(new SLKeyframe(p7Cfg, 0.5f)
				.setEndSide(SLSide.RIGHT, p6))
			.play();
		current_panel++;
	}};
	
	private final Runnable p7Action = new Runnable() {@Override public void run() {
		panel.createTransition()
			.push(new SLKeyframe(p2Cfg, 0.5f)
				.setEndSide(SLSide.RIGHT, p7))
			.play();
		current_panel++;
	}};
	private final JMenuItem _archiveMenuItem = new JMenuItem("Archive projects");

	public JMenuItem get_archiveMenuItem() {
		return _archiveMenuItem;
	}

	public JMenu get_toolsMenu() {
		return _toolsMenu;
	}

	public JMenuItem get_conventionMenuItem() {
		return _conventionMenuItem;
	}

	public JMenuItem get_helpMenuBtn() {
		return _helpMenuBtn;
	}

	public int getCurrent_panel() {
		return current_panel;
	}

	public void setCurrent_panel(int current_panel) {
		this.current_panel = current_panel;
	}
	
	

	public JLabel get_serverLbl() {
		return _serverLbl;
	}

	public SLPanel getPanel() {
		return panel;
	}
	
	public ThePanel getP1() {
		return p1;
	}

	public ThePanel getP2() {
		return p2;
	}

	public ThePanel getP3() {
		return p3;
	}

	public ThePanel getP4() {
		return p4;
	}

	public ThePanel getP5() {
		return p5;
	}

	public SLConfig getMainCfg() {
		return mainCfg;
	}

	public SLConfig getP1Cfg() {
		return p1Cfg;
	}

	public SLConfig getP2Cfg() {
		return p2Cfg;
	}

	public SLConfig getP3Cfg() {
		return p3Cfg;
	}

	public SLConfig getP4Cfg() {
		return p4Cfg;
	}

	public SLConfig getP5Cfg() {
		return p5Cfg;
	}

	public Runnable getP2Action() {
		return p2Action;
	}

	public Runnable getP3Action() {
		return p3Action;
	}

	public Runnable getP4Action() {
		return p4Action;
	}

	public Runnable getP5Action() {
		return p5Action;
	}
	
	
}
