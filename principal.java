import javax.swing.*;
import java.awt.event.*;

class principal 
{
	
	JButton calcularImc;
	JLabel texto,imc,peso,altura;
	JTextField inputPeso, inputImc;
	JTextField inputAltura;
	JMenuBar barra; 
	String strLine;
	JMenu arquivo, editar, formatar, exibir, sobre;
	JMenuItem sair;
	JMenuItem novo, abrir, salvar, copiar, colar, localizar, desenvolvedor;
	JFrame frame = new JFrame();
	JFrame appFrame;

	public principal()throws Exception
	{ 
		appFrame = new JFrame("Calculo de IMC");
		//JFrame frame = new JFrame("Calculo de IMC");
		
		JPanel principal = new JPanel();
		calcularImc = new JButton("Calcular");
		texto = new JLabel("Inicio");
		barra = new JMenuBar();
		principal.setLayout(new BoxLayout(principal, BoxLayout.PAGE_AXIS));
		imc = new JLabel("Seu IMC");
		peso = new JLabel("Digite seu peso");
		altura = new JLabel("Digite sua altura");
		inputPeso = new JTextField(4);
		inputAltura = new JTextField(4);
		inputImc = new JTextField(15);
		inputImc.setEnabled(false);
		//inputAltura.setSize(100, 150);
		JPanel labelPanel = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel imcPanel = new JPanel();
		JPanel calcular = new JPanel();
		
		//getContentPane().add(frame); 
		labelPanel.add(peso);
		labelPanel.add(inputPeso);
		
		textPanel.add(altura);
		textPanel.add(inputAltura);
		calcular.add(calcularImc);
		
		
		imcPanel.add(imc);
		imcPanel.add(inputImc);
		
		
		principal.add(labelPanel);
		principal.add(textPanel);
		principal.add(calcular);
		principal.add(imcPanel);
		//Menu arquivo
		arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic('A');
		novo = new JMenuItem ("Novo cálculo");
		novo.setMnemonic('v');
		
		sair = new JMenuItem("Sair");
		sair.setMnemonic ('S');

		sobre = new JMenu("Sobre");
		sobre.setMnemonic('o');
		desenvolvedor = new JMenuItem ("Sobre este programa");
		desenvolvedor.setMnemonic('V');

		
		barra.add(arquivo);
		barra.add(sobre);
		arquivo.add(novo);
		arquivo.add(sair);
		sobre.add(desenvolvedor);
		appFrame.setJMenuBar(barra);

		
		appFrame.add(principal);

		appFrame.setSize (320, 240);
		
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setVisible(true);
		
		calcularImc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try{
					if (inputAltura.getText().isEmpty() || inputPeso.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"ERRO: Favor fornecer peso e altura ", "ERRO", JOptionPane.ERROR_MESSAGE, null);
						throw new NullPointerException("Favor fornecer os dados de peso e altura");
					}
					System.out.println(inputPeso.getText());
					String imc = calcularImc(Integer.parseInt(inputPeso.getText()),Integer.parseInt(inputAltura.getText()));
					System.out.println(imc);
					inputImc.setText(imc);
					if (Integer.parseInt(imc) < 25 && Integer.parseInt(imc) > 18) {
						inputImc.setText(imc +" - Peso Normal");
					}else if (Integer.parseInt(imc) > 25 && Integer.parseInt(imc) < 30) {
						inputImc.setText(imc +" - Acima do peso");
					}else if (Integer.parseInt(imc) > 29 && Integer.parseInt(imc) < 35) {
						inputImc.setText(imc +" - Obesidade I");
					}else if (Integer.parseInt(imc) > 34 && Integer.parseInt(imc) < 40) {
						inputImc.setText(imc +" - Obesidade II (severa)");
					}
					
				}
				catch (Exception e1){//Catch exception if any
					System.err.println("Error: " + e1.getMessage());
				}
			}     
		});     
		
		
		sair.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}     
		});     
		
		
		novo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try{
					inputAltura.setText("");
					inputPeso.setText("");
					inputImc.setText("");
					
				}
				catch (Exception e1){//Catch exception if any
					System.err.println("Error: " + e1.getMessage());
				}
			}     
		});     

		desenvolvedor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Calculo de IMC. Por Rodrigo Simao.");

			}
		});
		
		
	}

	private String calcularImc(double peso,double altura) {
		int imc;
		System.out.println(altura);
		altura = altura/100;
		System.out.println(altura);
		altura = altura*altura;
		System.out.println(altura);
		imc = (int) (peso/altura);
		System.out.println(imc);
		return String.valueOf(imc);
		
	}

	
	public static void main(String args[]) throws Exception
	{
		new principal();
		
	}

}

