package patternComposite.folderFile;

public abstract class FolderComponent {
	public abstract double calcolaSpazio();
	
	public void add(FolderComponent fc) throws FileLeafException {
		throw new FileLeafException("I File non possono chiamare questo metodo");
		}
	public void remove(FolderComponent fc) throws FileLeafException {
		throw new FileLeafException("I File non possono chiamare questo metodo");
	};
}
