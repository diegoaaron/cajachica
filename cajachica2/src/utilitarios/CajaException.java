package utilitarios;

public class CajaException extends Exception {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String mensaje;

	public CajaException() {

	}

	public CajaException(int codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		// JOptionPane.showMessageDialog(null, codigo + " | " + mensaje, "Error",
		// JOptionPane.ERROR_MESSAGE);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
