package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import utilitarios.VariablesGlobales;
import controller.CajaChicaController;

public class RegistroCajaChica extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtmontoasignado;

	/**
	 * Create the frame.
	 */
	public RegistroCajaChica() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Registro de caja chica");
		setBounds(100, 100, 522, 118);
		getContentPane().setLayout(null);

		JLabel lblMontoAsignado = new JLabel("Monto asignado");
		lblMontoAsignado.setBounds(26, 25, 123, 24);
		getContentPane().add(lblMontoAsignado);

		txtmontoasignado = new JTextField();
		txtmontoasignado.setColumns(10);
		txtmontoasignado.setBounds(179, 26, 132, 24);
		getContentPane().add(txtmontoasignado);

		JButton btnGuardar = new JButton("Guadar");
		btnGuardar.setBounds(362, 24, 105, 27);
		getContentPane().add(btnGuardar);

		// metodos
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LocalDate fechaActual = LocalDate.now();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
				String fecha_registro = fechaActual.format(formato);

				int usuario_id = VariablesGlobales.USUARIO_ID;
				String nombre_proyecto = "caja_chica_" + fecha_registro;
				String descripcion = "caja chica del mes " + fecha_registro.substring(2, 4);
				double monto_asignado = Double.valueOf(txtmontoasignado.getText());
				String fecha_apertura = fecha_registro;

				try {
					new CajaChicaController().agregarCaja(usuario_id, nombre_proyecto, descripcion, monto_asignado, 0,
							0, fecha_apertura, "", "abierto");

					JOptionPane.showMessageDialog(null, "Caja chica del mes creada", "Éxito", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					txtmontoasignado.setText("");
				}

			}
		});

	}
}
