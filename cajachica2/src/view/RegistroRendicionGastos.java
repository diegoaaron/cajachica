package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import model.CajaChica;
import model.RendicionGastos;
import model.TipoCategoria;
import model.TipoComprobante;
import repository.RegistroRendicionGastosRepository;
import repository.RegistroCajaChicaRepository;
import repository.TipoCategoriaRepository;
import repository.TipoComprobanteRepository;
import utilitarios.VariablesGlobales;

import javax.swing.JComboBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class RegistroRendicionGastos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNumComprobante;
	private JTextField txtDescripGastos;
	private JTextField txtMonto;
	private JTable table;

	private ArrayList<TipoCategoria> tipoCategoriaArrayList;
	private ArrayList<TipoComprobante> tipoComprobanteArrayList;

	private ArrayList<RendicionGastos> registroRendicionGastosModelArrayList = new ArrayList<>();

	DefaultTableModel model; // manejador de elementos dentro de la tabla

	/**
	 * Create the frame.
	 */
	public RegistroRendicionGastos() {

		setTitle("Rendicion de gastos");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 961, 356);
		getContentPane().setLayout(null);

		JLabel lbolMontoTotal = new JLabel("Monto");
		lbolMontoTotal.setBounds(25, 232, 60, 17);
		getContentPane().add(lbolMontoTotal);

		JLabel lblCategoriaId = new JLabel("Tipo Categoria");
		lblCategoriaId.setBounds(25, 61, 98, 25);
		getContentPane().add(lblCategoriaId);

		JLabel lblTipoComprobante = new JLabel("Tipo Comprobante");
		lblTipoComprobante.setBounds(25, 108, 123, 25);
		getContentPane().add(lblTipoComprobante);

		JLabel lblNumeroComprobante = new JLabel("Numero Comprobante");
		lblNumeroComprobante.setBounds(25, 158, 155, 25);
		getContentPane().add(lblNumeroComprobante);

		JLabel lblDescripcionGastos = new JLabel("Descripción");
		lblDescripcionGastos.setBounds(25, 195, 137, 25);
		getContentPane().add(lblDescripcionGastos);

		txtNumComprobante = new JTextField();
		txtNumComprobante.setBounds(184, 160, 193, 21);
		txtNumComprobante.setColumns(10);
		getContentPane().add(txtNumComprobante);

		txtDescripGastos = new JTextField();
		txtDescripGastos.setBounds(184, 197, 193, 21);
		txtDescripGastos.setColumns(10);
		getContentPane().add(txtDescripGastos);

		txtMonto = new JTextField();
		txtMonto.setBounds(184, 230, 193, 21);
		txtMonto.setColumns(10);
		getContentPane().add(txtMonto);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(156, 275, 105, 27);
		getContentPane().add(btnAgregar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(654, 275, 105, 27);
		getContentPane().add(btnGuardar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 61, 528, 188);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Categoria", "T. comprobante", "N. comprobante", "Descripcion", "Monto" }));
		table.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(table);

		JLabel lblMontoAsignadoAl = new JLabel("Monto asignado al proyecto: ");
		lblMontoAsignadoAl.setBounds(458, 14, 178, 25);
		getContentPane().add(lblMontoAsignadoAl);

		JLabel lblNombreDelProyecto = new JLabel("Nombre del proyecto: ");
		lblNombreDelProyecto.setBounds(140, 14, 137, 25);
		getContentPane().add(lblNombreDelProyecto);

		JComboBox<TipoCategoria> cbmtipocategoria = new JComboBox<TipoCategoria>();
		cbmtipocategoria.setBounds(184, 61, 183, 25);
		getContentPane().add(cbmtipocategoria);

		JComboBox<TipoComprobante> cbmtipocomprobante = new JComboBox<TipoComprobante>();
		cbmtipocomprobante.setBounds(183, 107, 183, 26);
		getContentPane().add(cbmtipocomprobante);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(274, 16, 123, 21);
		lblNombre.setForeground(SystemColor.activeCaption);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		getContentPane().add(lblNombre);

		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonto.setForeground(SystemColor.activeCaption);
		lblMonto.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblMonto.setBounds(632, 18, 123, 21);
		getContentPane().add(lblMonto);

		// metodos

		// metodo que se gatilla al levantar el formulario
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {

				CajaChica miCajaChica = new RegistroCajaChicaRepository().listarProyecto(VariablesGlobales.USUARIO_ID);
				VariablesGlobales.CAJA_CHICA_ID = miCajaChica.getCaja_id();
				
				lblNombre.setText(miCajaChica.getNombre_proyecto());
				lblMonto.setText(String.valueOf(miCajaChica.getMonto_asignado()));

				tipoCategoriaArrayList = new TipoCategoriaRepository().obtenerTipoCategoria();

				cbmtipocategoria.addItem(new TipoCategoria());
				for (TipoCategoria tipoCategoria : tipoCategoriaArrayList) {
					cbmtipocategoria.addItem(tipoCategoria);
				}

				tipoComprobanteArrayList = new TipoComprobanteRepository().obtenerTipoComprobante();

				cbmtipocomprobante.addItem(new TipoComprobante());
				for (TipoComprobante tipoComprobante : tipoComprobanteArrayList) {
					cbmtipocomprobante.addItem(tipoComprobante);
				}

			}
		});

		// metodo que agrega elemenos a la lista
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LocalDate fechaActual = LocalDate.now();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");

				RendicionGastos registroRendicion;

				TipoCategoria tipoCategoriaSeleccionado = (TipoCategoria) cbmtipocategoria.getSelectedItem();
				TipoComprobante tipoComprobanteSeleccionado = (TipoComprobante) cbmtipocomprobante
						.getSelectedItem();

				// Acceder al modelo de la tabla
				model = (DefaultTableModel) table.getModel();

				if (tipoCategoriaSeleccionado != null && tipoComprobanteSeleccionado != null) {

					int caja_id = VariablesGlobales.CAJA_CHICA_ID;
					int categoria_id = tipoCategoriaSeleccionado.getCategoria_id();
					int tipo_comprobante_id = tipoComprobanteSeleccionado.getTipo_comprobante_id();
					String num_comprobante = txtNumComprobante.getText();
					String descripcion_gasto = txtDescripGastos.getText();
					double monto = Double.valueOf(txtMonto.getText());
					String fecha_registro = fechaActual.format(formato);
					String estado_aprobacion = "";

					try {

						model.addRow(new Object[] { String.valueOf(categoria_id), String.valueOf(tipo_comprobante_id),
								num_comprobante, descripcion_gasto, String.valueOf(monto) });

						registroRendicion = new RendicionGastos(caja_id, categoria_id, tipo_comprobante_id,
								num_comprobante, descripcion_gasto, monto, fecha_registro, estado_aprobacion);

						registroRendicionGastosModelArrayList.add(registroRendicion);

						cbmtipocategoria.setSelectedIndex(0);
						cbmtipocomprobante.setSelectedIndex(0);
						txtNumComprobante.setText("");
						txtDescripGastos.setText("");
						txtMonto.setText("");

						/*
						 * registroRendicion.setCaja_id(caja_id);
						 * registroRendicion.setCategoria_id(categoria_id);
						 * registroRendicion.setTipo_comprobante_id(tipo_comprobante_id);
						 * registroRendicion.setNum_comprobante(num_comprobante);
						 * registroRendicion.setDescripcion_gasto(descripcion_gasto);
						 * registroRendicion.setMonto(monto);
						 * registroRendicion.setFecha_registro(fecha_registro);
						 * registroRendicion.setEstado_aprobacion(estado_aprobacion);
						 * 
						 * new RegistroRendicionGastosRepository().guardar(registroRendicion);
						 * JOptionPane.showMessageDialog(null, "Rendicion completada", "Éxito",
						 * JOptionPane.INFORMATION_MESSAGE);
						 */

					} catch (Exception e2) {
						e2.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una categoria y tipo de comprobante");
				}

			}
		});

		// método que guarda la función en una base de datos
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					for (RendicionGastos registro : registroRendicionGastosModelArrayList) {
						new RegistroRendicionGastosRepository().guardar(registro);

					}

					model.setRowCount(0);

					JOptionPane.showMessageDialog(null, "Rendicion completada", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

	}
}
