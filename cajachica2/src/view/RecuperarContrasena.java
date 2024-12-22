package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Usuario;
import controller.UsuarioController;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecuperarContrasena extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField txtpassword;
	private JPasswordField txtpasswordval;

	private Usuario usuarioSeleccionado = null;

	/**
	 * Create the frame.
	 */
	public RecuperarContrasena() {

		setTitle("Recuperar Contraseña");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(30, 32, 60, 17);
		getContentPane().add(lblUsuario);

		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña");
		lblNuevaContrasea.setBounds(30, 86, 127, 24);
		getContentPane().add(lblNuevaContrasea);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña");
		lblConfirmarContrasea.setBounds(30, 136, 156, 31);
		getContentPane().add(lblConfirmarContrasea);

		txtpassword = new JPasswordField();
		txtpassword.setBounds(194, 88, 156, 22);
		getContentPane().add(txtpassword);

		txtpasswordval = new JPasswordField();
		txtpasswordval.setBounds(194, 141, 156, 22);
		getContentPane().add(txtpasswordval);

		JComboBox<Usuario> cbnuser = new JComboBox<Usuario>();
		cbnuser.setBounds(194, 27, 156, 26);
		getContentPane().add(cbnuser);

		JButton btnGuadar = new JButton("Guadar");
		btnGuadar.setBounds(162, 202, 105, 27);
		getContentPane().add(btnGuadar);

		// método que lista los usuarios activos al mostrar el formulario
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				ArrayList<Usuario> usuarioArrayList = new UsuarioController().listarUsuariosActivos();

				cbnuser.addItem(new Usuario());
				for (Usuario usuario : usuarioArrayList) {
					cbnuser.addItem(usuario);
				}
			}
		});

		// método gatillado en cada cambio del combobox
		cbnuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioSeleccionado = (Usuario) cbnuser.getSelectedItem();

				if (usuarioSeleccionado.getUsuario_id() == -1) {
					txtpassword.setEnabled(false);
					txtpasswordval.setEnabled(false);
					btnGuadar.setEnabled(false);
				} else {
					txtpassword.setEnabled(true);
					txtpasswordval.setEnabled(true);
					btnGuadar.setEnabled(true);
				}

			}
		});

		// método que guarda el cambio de contraseña
		btnGuadar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String password1 = new String(txtpassword.getPassword());
				String password2 = new String(txtpasswordval.getPassword());
				Usuario usuarioSeleccionado = (Usuario) cbnuser.getSelectedItem();

				try {

					if (password1.equals(password2)) {
						new UsuarioController().actualizarPassword(password2, usuarioSeleccionado.getUsuario_id());

						JOptionPane.showMessageDialog(null, "Password actualizado", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Los password no son iguales", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					txtpassword.setText("");
					txtpasswordval.setText("");
					cbnuser.setSelectedIndex(0);
				}
			}
		});

	}
}
