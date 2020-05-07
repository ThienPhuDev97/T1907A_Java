using System;

namespace Quanlisinhvien2
{
    class Program
    {
        static void Main(string[] args)
        {
            int choose;
            Manager manager = new Manager();
            do
            {
                showmenu();
                choose = int.Parse(Console.ReadLine());
                switch (choose)
                {
                    case 1:
                        manager.addStudent();
                        break;
                    case 2:
                        manager.display();
                        break;
                    case 3:
                        manager.sapxep();
                        break;
                    case 4:
                        manager.deletedsv();
                        break;
                    case 5:
                        Console.WriteLine("Exit success");
                        break;
                    default:
                        Console.WriteLine("nhap lai di");
                        break;

                        
                }

            } while (choose != 5);
        }
        static void showmenu()
        {
            Console.WriteLine("1: Them n sinh vien");
            Console.WriteLine("2: Hien thi danh sach sinh vien");
            Console.WriteLine("3: Sap xep danh sach sinh vien theo age");
            Console.WriteLine("4: Xoa sinh vien theo id");
            Console.WriteLine("5:Thoat");
            Console.WriteLine("Choose: ");
        }
    }
}
