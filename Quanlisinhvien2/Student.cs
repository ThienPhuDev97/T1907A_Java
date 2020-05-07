using System;
using System.Collections.Generic;
using System.Text;

namespace Quanlisinhvien2
{
    class Student
    {
        private string idSV, nameSv;
        private int ageSv;

        public string Idsv { get; set; }
        public string Namesv { get; set; }
        public int Agesv { get; set; }
        
        public Student() { }
        public Student(string idSV, string nameSv,int ageSv)
        {
            this.idSV = idSV;
            this.nameSv = nameSv;
            this.ageSv = ageSv;
        }
        public void input()
        {
            Console.WriteLine("Nhap id sinh vien");
            Idsv = Console.ReadLine();
            Console.WriteLine("nhap name sinh vien");
            Namesv = Console.ReadLine();
            Console.WriteLine("nhap age sinh vien");
            Agesv = int.Parse(Console.ReadLine());
        }
        public override string ToString()
        {
            return "idSv= " + Idsv + ", nameSv= " + Namesv + " , Agesv = " + Agesv;
        }

    }
}
