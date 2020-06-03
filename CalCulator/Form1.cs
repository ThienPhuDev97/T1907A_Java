using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Windows.Forms;
using MySql.Data;
using MySql.Data.MySqlClient;

namespace WindowsForms
{
    public partial class Form1 : Form
    {
        Double resultValue = 0;
        String operationPerformed = "";
        bool ischeck = false;
        List<string> list = new List<string>();
        List<string> listAll = new List<string>();
        string data;
        string nameFile = "demo.txt";
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button_click(object sender, EventArgs e)
        {
            if ((tbShownumber.Text == "0") || ischeck)
            {
                tbShownumber.Clear();
            }
            ischeck = false;
            if (!tbShownumber.Text.Contains("."))
            {
                Button button = (Button)sender;
                list.Add(button.Text);
                tbShownumber.Text = tbShownumber.Text + button.Text;

            }
            else
            {
                Button button = (Button)sender;
                if (!button.Text.Equals("."))
                    tbShownumber.Text = tbShownumber.Text + button.Text;
                list.Add(button.Text);
            }



        }

        private void operator_click(object sender, EventArgs e)
        {
            Button button = (Button)sender;

            if (resultValue != 0)
            {
                button16.PerformClick();
                operationPerformed = button.Text;
                list.Add(button.Text);
                resultValue = Convert.ToDouble(tbShownumber.Text);

                ischeck = true;
            }

            operationPerformed = button.Text;
            list.Add(button.Text);
            resultValue = Convert.ToDouble(tbShownumber.Text);

            show_calculator.Text = resultValue + " " + operationPerformed;
            ischeck = true;


        }

        private void button_click5(object sender, EventArgs e)
        {
            tbShownumber.Text = "0";
            resultValue = 0;
            list.Clear();
            data = "";
            show_calculator.Text = "";
        }

        private void button_click4(object sender, EventArgs e)
        {
            tbShownumber.Text = "0";
        }

        private void button_result(object sender, EventArgs e)
        {
            show_calculator.Text = show_calculator.Text + " " + tbShownumber.Text;
            switch (operationPerformed)
            {

                case "+":
                    tbShownumber.Text = (resultValue + Convert.ToDouble(tbShownumber.Text)).ToString();

                    break;
                case "-":
                    tbShownumber.Text = (resultValue - Convert.ToDouble(tbShownumber.Text)).ToString();
                    break;
                case "*":
                    tbShownumber.Text = (resultValue * Convert.ToDouble(tbShownumber.Text)).ToString();
                    break;
                case "/":
                    tbShownumber.Text = (resultValue / Convert.ToDouble(tbShownumber.Text)).ToString();
                    break;
                default:
                    break;

            }

            list.Add("=" + tbShownumber.Text);
            foreach (var item in list)
            {
                data += item;
            }
            
            show_calculator.Text = data;
            StreamWriter writer = new StreamWriter(nameFile, true);
            writer.WriteLine(data);
            writer.Close();
            insertMysql(data);
        }
        private void insertMysql(string data)
        {
            string strConnection = "Server = localhost;Database=test;Port=3306;User ID=root;password=";
            MySqlConnection connection = new MySqlConnection(strConnection); ;
            try
            {
                
                connection.Open();

                string data_insert = "INSERT INTO calculator(result) VALUES ('"+data+"')";
                MySqlCommand command = new MySqlCommand(data_insert,connection);
                command.ExecuteNonQuery();
                Console.WriteLine("hoan thanh success");
            }
            catch (Exception ex)
            {

                Console.WriteLine("ket noi error "+ex.Message);
            }
            finally
            {
                connection.Close();
                connection.Dispose();
            }
        }
       
    }


}


