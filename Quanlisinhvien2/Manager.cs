using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Quanlisinhvien2
{
    class Manager
    {
        ArrayList arrayList = new ArrayList();

        public Manager() { }
        public ArrayList ArrayList { get; set; }

       //add N student
        public void addStudent()
        {
            Console.WriteLine("Nhap N sinh vien can them" );
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                Student st = new Student();
                st.input();
                arrayList.Add(st);
            }
        }

        //show arrayList
        public void display()
        {
            Console.WriteLine("Danh sach sinh vien");
            foreach (Student st in arrayList)
            {
                Console.WriteLine(st.ToString());
            }
        }
        
        //sort by age student
        public void sapxep()
        {
            arrayList.Sort(new SortByage());
            display();
        }
        //deleted theo idsv
        public void deletedsv()
        {
            Student st1 = null;
            Console.WriteLine("Nhap id sv can xoa: ");
            string id = Console.ReadLine();

            bool ischeck = false;
            foreach (Student st in arrayList)
            {
                if (st.Idsv.Equals(id))
                {
                    ischeck = true;
                    st1 = st;
                    break;
                }
            }
            if (ischeck)
            {
                arrayList.Remove(st1);
                Console.WriteLine("Xoa thanh cong sv co id = "+id);
                return;
            }
            Console.WriteLine("ID= "+id+" khong ton tai trong danh sach");

        }
    }
}
