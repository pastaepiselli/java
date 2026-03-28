package patternComposite.folderFile;

public class FileLeaf extends FolderComponent {
	private double bytes;
	
	public FileLeaf(double bytes) {
		this.bytes = bytes;
	}

	@Override
	public double calcolaSpazio() {
		return bytes;
	}

	
	

}
