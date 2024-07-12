
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class filefind {
	public static String name;
	public static String path;

	public JFileChooser fc = new JFileChooser();
	JPanel pnl = new JPanel();
	public JFrame frame = new JFrame();
	public static File selectedfile;

	public filefind(String dialog, String ext_blurb, String ext) {
		frame.add(fc);
		fc.setDialogTitle(dialog);
		FileNameExtensionFilter ff = new FileNameExtensionFilter(ext_blurb, ext);
		fc.addChoosableFileFilter(ff);
		fc.setFileFilter(ff);

		Path currentRelativePath = Paths.get("");
		File workingDirectory = currentRelativePath.toAbsolutePath().toFile();

		fc.setCurrentDirectory(workingDirectory);

		int result = fc.showOpenDialog(frame);
		frame.setFocusable(true);
		frame.setFocusableWindowState(true);

		switch (result) {
			case JFileChooser.APPROVE_OPTION:
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				selectedfile = fc.getSelectedFile().getAbsoluteFile();

				System.out.println(selectedfile);
				getFileName(selectedfile);

				break;
			case JFileChooser.CANCEL_OPTION:
				System.out.println("Bye!");
				System.exit(0);
				break;
			case JFileChooser.ERROR_OPTION:
				System.out.println("Error");
				break;

		}

	}

	public String getFileName(File selectedfile) {

		// TODO Auto-generated method stub
		name = selectedfile.getName();
		System.out.println(name);


		return name;

	}

	public static void main(String[] args) {

	}

}