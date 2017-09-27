package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class JanelaTabela extends JFrame {

    private JTextField txtNome = new JTextField(20);
    private JTextField txtIdade = new JTextField(2);
    private JTextField txtEmail = new JTextField(40);
    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnRemover = new JButton("Remover");
    private JButton btnSalvar = new JButton("Salvar");

    private JTable tabela;
    private List<Pessoa> dados;

    public JanelaTabela(List<Pessoa> dados) throws HeadlessException {
        super("Tabelas 01");
        this.dados = dados;
        tabela = new JTable(new PessoaTableModel(dados));
        btnSalvar.setEnabled(false);
        btnRemover.setEnabled(false);

        JPanel formulario = new JPanel();
        formulario.setLayout(new GridLayout(2, 3));
        formulario.add(txtNome);
        formulario.add(txtIdade);
        formulario.add(txtEmail);
        formulario.add(btnSalvar);
        formulario.add(btnRemover);
        formulario.add(btnAdicionar);

        add(formulario, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tabela.getSelectedRowCount() == 0) {
                    btnRemover.setEnabled(false);
                    btnSalvar.setEnabled(false);
                    btnAdicionar.setEnabled(true);
                } else {
                    btnAdicionar.setEnabled(false);
                    btnRemover.setEnabled(true);
                    btnSalvar.setEnabled(true);
                    PessoaTableModel modelo = (PessoaTableModel) tabela.getModel();
                    int linha = tabela.getSelectedRow();
                    txtNome.setText((String)modelo.getValueAt(linha, 0));
                    txtIdade.setText(modelo.getValueAt(linha, 1).toString());
                    txtEmail.setText((String)modelo.getValueAt(linha, 2));
                }
            }
        });

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaTableModel modelo = (PessoaTableModel) tabela.getModel();
                Pessoa p = new Pessoa(
                    txtNome.getText(),
                    Integer.parseInt(txtIdade.getText()),
                    txtEmail.getText()
                );
                modelo.add(p);
                txtNome.setText("");
                txtIdade.setText("");
                txtEmail.setText("");
                txtNome.requestFocus();
            }
        });
        
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabela.getSelectedRowCount()==0) return;
                DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
                modelo.removeRow(tabela.getSelectedRow());
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabela.getSelectedRowCount()==0) return;
                PessoaTableModel modelo = (PessoaTableModel)tabela.getModel();
                int linha  = tabela.getSelectedRow();
                
                dados.get(linha).setNome(txtNome.getText());
                dados.get(linha).setIdade(Integer.parseInt(txtIdade.getText()));
                dados.get(linha).setEmail(txtEmail.getText());
                txtNome.setText("");
                txtIdade.setText("");
                txtEmail.setText("");
                tabela.clearSelection();
                txtNome.requestFocus();
            }
        });
    }

}
