package view;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CajaChica;
import model.RendicionGastos;
import utilitarios.VariablesGlobales;
import controller.CajaChicaController;
import controller.RendicionGastosController;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AprobacionGastos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	private ArrayList<CajaChica> cajasChicasArrayList;
	private ArrayList<RendicionGastos> obtenerGastosPorCajaChicaPorIdList;
	private DefaultTableModel datosTabla; // datos de la tabla en la instancia
	private int monto_total_gastado_t; // monto que se esta trabajando en la instancia

	// Constructor
	public AprobacionGastos() {

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("AprobacionGastos");
		setBounds(100, 100, 686, 292);
		getContentPane().setLayout(null);

		JComboBox<CajaChica> cbmProyectos = new JComboBox<CajaChica>();
		cbmProyectos.setBounds(136, 12, 171, 26);
		getContentPane().add(cbmProyectos);

		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setBounds(41, 17, 60, 17);
		getContentPane().add(lblProyecto);

		JButton btnAprobar = new JButton("Aprobar");
		btnAprobar.setBounds(343, 12, 105, 27);
		getContentPane().add(btnAprobar);

		JLabel lblUsuarioAsignado = new JLabel("Usuario asignado");
		lblUsuarioAsignado.setBounds(41, 61, 137, 25);
		getContentPane().add(lblUsuarioAsignado);

		JLabel lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(SystemColor.activeCaption);
		lblNombre.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblNombre.setBounds(152, 63, 99, 21);
		getContentPane().add(lblNombre);

		JLabel lblMontoGastado = new JLabel("");
		lblMontoGastado.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontoGastado.setForeground(SystemColor.activeCaption);
		lblMontoGastado.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblMontoGastado.setBounds(349, 227, 123, 21);
		getContentPane().add(lblMontoGastado);

		JLabel lblUsuarioAsignado_1 = new JLabel("Monto total gastado");
		lblUsuarioAsignado_1.setBounds(190, 225, 137, 25);
		getContentPane().add(lblUsuarioAsignado_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 98, 512, 115);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Categoria", "T. Comprobante", "N. Comprobante", "Descripcion", "Monto" }));
		scrollPane.setViewportView(table);

		JLabel lblMontoDeLa = new JLabel("Monto de la caja chica");
		lblMontoDeLa.setBounds(390, 61, 137, 25);
		getContentPane().add(lblMontoDeLa);

		JLabel lblMontocajachica = new JLabel("");
		lblMontocajachica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontocajachica.setForeground(SystemColor.activeCaption);
		lblMontocajachica.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblMontocajachica.setBounds(530, 61, 99, 21);
		getContentPane().add(lblMontocajachica);

		// métodos

		// método gatillado al mostrar la ventana
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {

				// cargado de cajas chicas abiertas
				cajasChicasArrayList = new CajaChicaController().listarCajasAbiertas();

				// agregando un item en blanco inicial
				cbmProyectos.addItem(new CajaChica());

				// llenando del combobox con las cajas chicas abiertas
				for (CajaChica cajaChica : cajasChicasArrayList) {
					cbmProyectos.addItem(cajaChica);
				}
			}
		});

		// método gatillado cuando seleccionamos un elemento del combobox
		cbmProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// item de turno
				CajaChica itemSeleccionado = null;

				// accediento a los datos de la tabla
				datosTabla = (DefaultTableModel) table.getModel();

				// seteando la tabla en blanco
				datosTabla.setRowCount(0);

				// definimos en cero el monto total de los gastos
				monto_total_gastado_t = 0;

				// obteniendo el item seleccionado
				itemSeleccionado = (CajaChica) cbmProyectos.getSelectedItem();

				VariablesGlobales.CAJA_CHICA_ID = itemSeleccionado.getCaja_id();

				if (VariablesGlobales.CAJA_CHICA_ID == -1) {

					// reseteando las etiquetas en blanco
					lblNombre.setText("");
					lblMontocajachica.setText("");
					lblMontoGastado.setText("");

					// limpiando el monto total de los items gastados
					monto_total_gastado_t = 0;

					// deshabilitando el botón de aprobacion de gastos de caja chica
					btnAprobar.setEnabled(false);
				} else {

					// llenando los valores de las etiquetas
					lblNombre.setText(itemSeleccionado.getNombre_proyecto());
					lblMontocajachica.setText(String.valueOf(itemSeleccionado.getMonto_asignado()));
					lblMontoGastado.setText(String.valueOf(monto_total_gastado_t));

					// obteniendo la lista de gastos de la caja chica seleccionada
					obtenerGastosPorCajaChicaPorIdList = new RendicionGastosController()
							.obtenerGastosPorCajaChica(VariablesGlobales.CAJA_CHICA_ID);

					// mostrando los valores de los gastos de la caja chica seleccionada
					for (RendicionGastos registroGastosPorCajaChica : obtenerGastosPorCajaChicaPorIdList) {

						int categoria_id = registroGastosPorCajaChica.getCategoria_id();
						int tipo_comprobante_id = registroGastosPorCajaChica.getTipo_comprobante_id();
						String num_comprobante = registroGastosPorCajaChica.getNum_comprobante();
						String descripcion_gasto = registroGastosPorCajaChica.getDescripcion_gasto();
						double monto = registroGastosPorCajaChica.getMonto();

						Object[] filaDatos = new Object[] { String.valueOf(categoria_id),
								String.valueOf(tipo_comprobante_id), num_comprobante, descripcion_gasto,
								String.valueOf(monto) };

						datosTabla.addRow(filaDatos);

						monto_total_gastado_t += registroGastosPorCajaChica.getMonto();
					}

					// habilitando el botón de aprobacion de gastos de caja chica
					btnAprobar.setEnabled(true);
				}
			}
		});

		// método del boton de aprobación, que aprueba los gastos mostrados
		btnAprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// aprobando los gastos obtenidos para la caja chica
				new RendicionGastosController().aprobarRendicionGastos(VariablesGlobales.CAJA_CHICA_ID);

				// aprobando la caja chica para darla por finalizada
				new CajaChicaController().aprobarCajaChica(VariablesGlobales.CAJA_CHICA_ID);

				// seteando la tabla en blanco
				datosTabla.setRowCount(0);

				// reseteando las etiquetas en blanco
				lblNombre.setText("");
				lblMontocajachica.setText("");
				lblMontoGastado.setText("");

				// limpiando el monto total de los items gastados
				monto_total_gastado_t = 0;

				// deshabilitando el botón de aprobacion de gastos de caja chica
				btnAprobar.setEnabled(false);

				// deshabilitando los eventos en el combobox
				for (ActionListener listener : cbmProyectos.getActionListeners()) {
					cbmProyectos.removeActionListener(listener);
				}

				// limpiando los elementos existentes en el JComboBox
				cbmProyectos.removeAllItems();

				// agregando el item en blanco inicial
				cbmProyectos.addItem(new CajaChica());

				// cargando los datos para llenar nuevamenteel combobox
				cajasChicasArrayList = new CajaChicaController().listarCajasAbiertas();

				// llenado del combobox con las cajas chicas abiertas
				for (CajaChica cajaChica : cajasChicasArrayList) {
					cbmProyectos.addItem(cajaChica);
				}

				// seleccionando por defecto el item en blanco creado
				cbmProyectos.setSelectedItem(0);

				// habilitando nuevamente los eventos en el combobox
				for (ActionListener listener : cbmProyectos.getActionListeners()) {
					cbmProyectos.addActionListener(listener);
				}

				// mostrando mensaje final
				JOptionPane.showMessageDialog(null, "Aprobacion completada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}
}
