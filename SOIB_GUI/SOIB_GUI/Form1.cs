using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;

namespace SOIB_GUI
{
    public partial class Form1 : Form
    {
        private string channels, length, iterations, upgrades;
        private string frequencies, collision;
        private string path;

        public Form1()
        {
            InitializeComponent();

            btn_OK.Click += new System.EventHandler(OnClick);
            
            
        }

        private void OnClick(object sender, EventArgs e)
        {
            channels = txtBox_channels.Text;
            length = txtBox_length.Text;
            iterations = txtBox_iterations.Text;
            upgrades = txtBox_upgrades.Text;

            // Create a string array with the lines of text
            string[] lines = { "Input_frequencies_number=" + channels, "Max_iterations_number=" + iterations, "Max_window_size=" + length, "Max_upgrades_number=" + upgrades};
            // Set a variable to the Documents path
            //string workingDirectory = Environment.CurrentDirectory;
            //string docPath = Directory.GetParent(workingDirectory).Parent.FullName;
            string docPath = "E:/Piotr/Programowanie/Kotlin/SOIB_9/src/main/resources/";
            //string docPath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            // Write the string array to a new file named "parameters.txt"
            using (StreamWriter outputFile = new StreamWriter(Path.Combine(docPath, "parameters.txt")))
            {
                foreach (string line in lines)
                    outputFile.WriteLine(line);
            }

            string file = Path.Combine(docPath, "solution.txt");
            File.Delete(file);

            runJar();
            //ExecuteCommand("java -jar ./SOIB_9.jar");

            while (!File.Exists(file))
            {
                System.Threading.Thread.Sleep(1000);
            }
            
            //System.Threading.Thread.Sleep(1000);
            LoadFromFile(path, file);
        }

        private void LoadFromFile(string path, string file)
        {
           
            string[] lines = File.ReadAllLines(file);
            foreach (string line in lines)
            {
                if (line.StartsWith("collisions"))
                    richTextBox_results.Text += "Number of collisions: " + line.Substring(11) + "\n";
                else if (line.StartsWith("iterations"))
                    richTextBox_results.Text += "Number of iterations: " + line.Substring(11) + "\n";
                else if (line.StartsWith("upgrades"))
                    richTextBox_results.Text += "Number of upgrades: " + line.Substring(9) + "\n";
                else if (line.StartsWith("solution"))
                    richTextBox_results.Text += "Solution: " + line.Substring(9) + "\n\n";
            }

            var sb = new StringBuilder();
            foreach (string line in lines)
            {
                if (line.StartsWith("collisions"))
                    sb.Append("Number of collisions: " + line.Substring(11) + "\n");
                else if (line.StartsWith("iterations"))
                    sb.Append("Number of iterations: " + line.Substring(11) + "\n");
                else if (line.StartsWith("upgrades"))
                    sb.Append("Number of upgrades: " + line.Substring(9) + "\n");
                else if (line.StartsWith("solution"))
                    sb.Append("Solution: " + line.Substring(9) + "\n\n");
            }

            MessageBox.Show(sb.ToString(), "Results");
        }

        /*
        private void LoadFromFile(string path)
        {
            //TODO: load results from file
            //string workingDirectory = Environment.CurrentDirectory;
            //string docPath = Directory.GetParent(workingDirectory).Parent.FullName;
            string docPath = "./src/main/resources/";
            string[] lines = File.ReadAllLines(Path.Combine(docPath, "solution.txt"));

            foreach (string line in lines)
            {
                if (line.StartsWith("collisions"))
                    richTextBox_results.Text += "Number of collisions: " + line.Substring(11) + "\n";
                else if (line.StartsWith("iterations"))
                    richTextBox_results.Text += "Number of iterations: " + line.Substring(11) + "\n";
                else if (line.StartsWith("upgrades"))
                    richTextBox_results.Text += "Number of upgrades: " + line.Substring(9) + "\n";
                else if (line.StartsWith("solution"))
                    richTextBox_results.Text += "Solution: " + line.Substring(9) + "\n";

            }
                
        }
        */

        public void runJar()
        {
            // set path of JAR file
            string path = "";
            Process process = new Process();
            process.EnableRaisingEvents = false;
            process.StartInfo.FileName = "java";
            // change name of JAR file
            process.StartInfo.Arguments = "-jar " + "./SOIB_9.jar";
            process.Start();
        }

        public void ExecuteCommand(string Command)
        {
            ProcessStartInfo ProcessInfo;
            Process Process;

            ProcessInfo = new ProcessStartInfo("cmd.exe", "/K " + Command);
            ProcessInfo.CreateNoWindow = true;
            ProcessInfo.UseShellExecute = true;

            Process = Process.Start(ProcessInfo);
        }
    }
}
