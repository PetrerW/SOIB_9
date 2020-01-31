namespace SOIB_GUI
{
    partial class Form1
    {
        /// <summary>
        /// Wymagana zmienna projektanta.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Wyczyść wszystkie używane zasoby.
        /// </summary>
        /// <param name="disposing">prawda, jeżeli zarządzane zasoby powinny zostać zlikwidowane; Fałsz w przeciwnym wypadku.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Kod generowany przez Projektanta formularzy systemu Windows

        /// <summary>
        /// Metoda wymagana do obsługi projektanta — nie należy modyfikować
        /// jej zawartości w edytorze kodu.
        /// </summary>
        private void InitializeComponent()
        {
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtBox_channels = new System.Windows.Forms.TextBox();
            this.txtBox_length = new System.Windows.Forms.TextBox();
            this.btn_OK = new System.Windows.Forms.Button();
            this.richTextBox_results = new System.Windows.Forms.RichTextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtBox_iterations = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txtBox_upgrades = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 84);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(268, 20);
            this.label2.TabIndex = 1;
            this.label2.Text = "Upper bound on the length of ruler:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 16);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(164, 20);
            this.label1.TabIndex = 2;
            this.label1.Text = "Number of channels:";
            // 
            // txtBox_channels
            // 
            this.txtBox_channels.Location = new System.Drawing.Point(292, 13);
            this.txtBox_channels.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBox_channels.Name = "txtBox_channels";
            this.txtBox_channels.Size = new System.Drawing.Size(100, 27);
            this.txtBox_channels.TabIndex = 3;
            // 
            // txtBox_length
            // 
            this.txtBox_length.Location = new System.Drawing.Point(292, 81);
            this.txtBox_length.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBox_length.Name = "txtBox_length";
            this.txtBox_length.Size = new System.Drawing.Size(100, 27);
            this.txtBox_length.TabIndex = 4;
            // 
            // btn_OK
            // 
            this.btn_OK.Location = new System.Drawing.Point(20, 148);
            this.btn_OK.Name = "btn_OK";
            this.btn_OK.Size = new System.Drawing.Size(372, 25);
            this.btn_OK.TabIndex = 5;
            this.btn_OK.Text = "OK";
            this.btn_OK.UseVisualStyleBackColor = true;
            // 
            // richTextBox_results
            // 
            this.richTextBox_results.Location = new System.Drawing.Point(20, 179);
            this.richTextBox_results.Name = "richTextBox_results";
            this.richTextBox_results.ReadOnly = true;
            this.richTextBox_results.Size = new System.Drawing.Size(372, 205);
            this.richTextBox_results.TabIndex = 6;
            this.richTextBox_results.Text = "";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 50);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(249, 20);
            this.label3.TabIndex = 7;
            this.label3.Text = "Maximum number of interations:";
            // 
            // txtBox_iterations
            // 
            this.txtBox_iterations.Location = new System.Drawing.Point(292, 47);
            this.txtBox_iterations.Name = "txtBox_iterations";
            this.txtBox_iterations.Size = new System.Drawing.Size(100, 27);
            this.txtBox_iterations.TabIndex = 8;
            this.txtBox_iterations.Text = "4000000";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 118);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(240, 20);
            this.label4.TabIndex = 9;
            this.label4.Text = "Maximum number of upgrades:";
            // 
            // txtBox_upgrades
            // 
            this.txtBox_upgrades.Location = new System.Drawing.Point(292, 115);
            this.txtBox_upgrades.Name = "txtBox_upgrades";
            this.txtBox_upgrades.Size = new System.Drawing.Size(100, 27);
            this.txtBox_upgrades.TabIndex = 10;
            this.txtBox_upgrades.Text = "50";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(414, 396);
            this.Controls.Add(this.txtBox_upgrades);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.txtBox_iterations);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.richTextBox_results);
            this.Controls.Add(this.btn_OK);
            this.Controls.Add(this.txtBox_length);
            this.Controls.Add(this.txtBox_channels);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label2);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "Form1";
            this.Text = "Golomb ruler sequence generation for FWM";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtBox_channels;
        private System.Windows.Forms.TextBox txtBox_length;
        private System.Windows.Forms.Button btn_OK;
        private System.Windows.Forms.RichTextBox richTextBox_results;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtBox_iterations;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtBox_upgrades;
    }
}

