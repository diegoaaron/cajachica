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

import model.CajaChica;
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

				CajaChica registroCajaChicaModel = new CajaChica();

				LocalDate fechaActual = LocalDate.now();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
				String fecha_registro = fechaActual.format(formato);

				int usuario_id = 1;
				String nombre_proyecto = "caja_chica_" + fecha_registro;
				String descripcion = "caja chica del mes " + fecha_registro.substring(2, 4);
				double monto_asignado = Double.valueOf(txtmontoasignado.getText());
				String fecha_apertura = fecha_registro;

				try {

					registroCajaChicaModel.setUsuario_id(usuario_id);
					registroCajaChicaModel.setNombre_proyecto(nombre_proyecto);
					registroCajaChicaModel.setDescripcion(descripcion);
					registroCajaChicaModel.setMonto_asignado(monto_asignado);
					registroCajaChicaModel.setMonto_gastado(0);
					registroCajaChicaModel.setMonto_cierre(0);
					registroCajaChicaModel.setFecha_apertura(fecha_apertura);
					registroCajaChicaModel.setFecha_cierre("");

					new RegistroCajaChicaRepository().guardar(registroCajaChicaModel);

					JOptionPane.showMessageDialog(null, descripcion + " asignado");

					txtmontoasignado.setText("");

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}
}
