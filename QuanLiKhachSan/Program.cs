using System;
using System.Collections.Generic;
using System.Text;

namespace QuanLiKhachSan
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            
            int choose;
            List<Hotel> hotelList = new List<Hotel>();
            var listCustomers = new List<Customer>();
            List<Book> listBooks = new List<Book>();

            do
            {
                showAllMenu();
                choose = Convert.ToInt32(Console.ReadLine());
                switch (choose)
                {
                    case 1:
                        showmenu(hotelList);
                        
                        break;
                    case 2:
                        Manage.showMenuCustomer(listCustomers);
                        break;
                    case 3:
                        showBooking(hotelList, listBooks,listCustomers);
                        break;
                    case 4:
                        Manage.ShowMenuSearch(hotelList, listCustomers);
                        break;

                }

            } while (choose !=5);
        }

        public static void showmenu(List<Hotel> list)
        {
            int choose;
            
            do
            {
                Console.WriteLine("1. Them Khach San");
                Console.WriteLine("2. Sua Khach San");
                Console.WriteLine("3. Xoa Khach San");
                Console.WriteLine("4. Quay lai menu");
                
                Console.WriteLine("Chon:");
                choose = Convert.ToInt32(Console.ReadLine());
                switch (choose)
                {
                    case 1:
                        Manage.InputInforHotel(list);
                        Manage.showInfoHotel(list);
                        break;
                    case 2:
                        Manage.EditHotel(list);
                        break;
                    case 3:
                        Manage.DeletedHotel(list);
                        break;
                    case 4:
                        
                        break;
                    default:
                        Console.WriteLine("Chon sai roi");
                        break;

                }
            } while (choose!=4);
            
            
        }
        public static void showAllMenu()
        {
            Console.WriteLine("1.Quan Li Khach San");
            Console.WriteLine("2.Quan Li Khach Hang");
            Console.WriteLine("3.Quan Li Dat Phong");
            Console.WriteLine("4.Tim Kiem");
            Console.WriteLine("5. Thoat");
            Console.WriteLine("Choose :");
        }

        public static void showBooking(List<Hotel> listHotel, List<Book> listBooks, List<Customer> customers)
        {
            int choose;
            do
            {
                Console.WriteLine("1. Tim phong trong");
                Console.WriteLine("2. Dat phong");
                Console.WriteLine("3. Xem thong tin cac phong dat");
                Console.WriteLine("4. Quay lai menu");
                Console.WriteLine("Choose: ");
                choose = Convert.ToInt32(Console.ReadLine());
                switch (choose)
                {
                    case 1:
                        Manage.FindBookingAvaiable(listHotel, listBooks);
                        break;
                    case 2:
                        Manage.Booking(customers,listHotel,listBooks);
                        break;
                    case 3:
                        Manage.showInfoBook(listBooks);
                        break;
                    case 4:
                        break;
                    default:
                        Console.WriteLine("Chon lai");
                        break;
                }
            } while (choose!= 4);

        }
    }
}
