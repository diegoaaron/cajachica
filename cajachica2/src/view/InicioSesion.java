package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UsuarioController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioSesion() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Iniciar Sesion");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(121, 0, 124, 21);
		contentPane.add(lblTitulo);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(12, 37, 60, 17);
		contentPane.add(lblCorreo);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(12, 78, 60, 17);
		contentPane.add(lblClave);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(90, 33, 232, 21);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(90, 76, 232, 21);
		contentPane.add(txtClave);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(140, 109, 105, 27);
		contentPane.add(btnIngresar);

		// metodos
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UsuarioController usuarioController = new UsuarioController();

				try {
					String correo = txtCorreo.getText();
					String clave = new String(txtClave.getPassword());

					usuarioController.iniciarSesion(correo, clave);
					dispose();
				} catch (Exception a) {
					a.printStackTrace();
				}
				txtCorreo.setText("");
				txtClave.setText("");
			}
		});

	}

}
