package textAdventure;

public class Nemico {
	private String nome;
	private int hp;
	private int danno;
	private int hpMax;
	
	public Nemico(String nome, int hp, int danno) {
		this.nome = nome;
		this.hp = hp;
		this.danno = danno;
		this.hpMax = hp;
	}

	public String getNome() {
		return nome;
	}

	public int getHp() {
		return hp;
	}

	public int getDanno() {
		return danno;
	}
	
	public int getHpMax() {
		return this.hpMax;
	}
	public boolean takeDamage(int damage){
		this.hp -= damage;
		if (this.hp <= 0) {
			this.hp = 0;
			return true; // morto :(
		}
		
		return false;
	}
	
}
