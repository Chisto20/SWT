package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class App {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			App window = new App();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblUnidades = new Label(shell, SWT.NONE);
		lblUnidades.setFont(SWTResourceManager.getFont("Snap ITC", 16, SWT.NORMAL));
		lblUnidades.setBounds(35, 23, 106, 21);
		lblUnidades.setText("Unidades");
		
		Label lblPrecio = new Label(shell, SWT.NONE);
		lblPrecio.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPrecio.setFont(SWTResourceManager.getFont("Snap ITC", 16, SWT.NORMAL));
		lblPrecio.setBounds(35, 98, 89, 21);
		lblPrecio.setText("Precio");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(263, 23, 76, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(263, 98, 76, 21);
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(35, 187, 304, 39);
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.setFont(SWTResourceManager.getFont("Snap ITC", 16, SWT.NORMAL));
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int uni=Integer.parseInt(text.getText());
				float pre=Float.parseFloat(text_1.getText());
				
				if(pre == 0) {
					lblNewLabel.setText("Error, precio no puede ser 0");
				}
				else if(uni == 0) {
					lblNewLabel.setText("Error, unidad no puede ser 0");
				}else {
				
				lblNewLabel.setText(String.valueOf(uni*pre));
			}}
		});
		btnCalcular.setBounds(141, 143, 106, 38);
		btnCalcular.setText("Calcular");
		
		

	}
}
