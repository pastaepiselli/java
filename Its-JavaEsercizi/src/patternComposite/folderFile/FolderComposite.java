package patternComposite.folderFile;

import java.util.ArrayList;
import java.util.List;

public class FolderComposite extends FolderComponent {
	private List<FolderComponent> children;
	public FolderComposite() {
		children = new ArrayList<FolderComponent>();
	}
	
	public FolderComposite(List<FolderComponent> contiene) {
		super();
		this.children = contiene;
	}
	

	// dovrebbe essere il getChilderen
	public List<FolderComponent> getContiene() {
		return children;
	}
	

	@Override
	public void add(FolderComponent fc) {
		// TODO Auto-generated method stub
		children.add(fc);
	}

	@Override
	public void remove(FolderComponent fc) {
		// TODO Auto-generated method stub
		children.remove(fc);
	}

	public void setContiene(List<FolderComponent> contiene) {
		this.children = contiene;
	}

	@Override
	public double calcolaSpazio() {
		double spazio = 0;
		for (FolderComponent fc : children) {
			spazio += fc.calcolaSpazio();
		}
		return spazio;
	}

}
