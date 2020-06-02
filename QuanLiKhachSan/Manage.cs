using System;
using System.Collections.Generic;
using System.Reflection.Metadata.Ecma335;
using System.Runtime.InteropServices;

namespace QuanLiKhachSan
{
    class Manage
    {
        public static void InputInforHotel(List<Hotel> listHotel)
        {
            Console.WriteLine("input N hotel");
            int n = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                Hotel hotel = new Hotel();
                hotel.inputHotel();
                listHotel.Add(hotel);
            }


        }
        //in thong tin hotel 
        public static void showInfoHotel(List<Hotel> listHotel)
        {
            foreach (var item in listHotel)
            {
                item.display();
            }
        }

        public static Hotel searchByID(List<Hotel> listHotel)
        {
            Console.WriteLine("nhap ID khach san");
            string id_hotel = Console.ReadLine();
            Hotel ht = null;

            foreach (var item in listHotel)
            {
                if (item.Id_Hotel.Equals(id_hotel))
                {
                    ht = item;
                    break;
                }
            }
            return ht;
        }
        //deleted khach san theo id
        public static void DeletedHotel(List<Hotel> listHotel)
        {
            Hotel ht = searchByID(listHotel);
            if (ht != null)
            {
                Console.WriteLine("Xoa thanh cong id-hotel = {0}", ht.Id_Hotel);
                listHotel.Remove(ht);
                Console.WriteLine("Danh sach ks sau khi deleted");
                showInfoHotel(listHotel);
                return;
            }
            Console.WriteLine("id hotel khong ton tai ");

        }

        //edit hotel 
        public static void EditHotel(List<Hotel> listHotel)
        {
            Hotel ht = searchByID(listHotel);
            if (ht == null)
            {
                Console.WriteLine("id hotel khong ton tai");
                return;
            }
            Console.WriteLine("Thong tin khach san : {0}", ht.NameHotel);
            ht.display();
            ht.updateHotel();
            Console.WriteLine("sau khi update");
            ht.display();
        }

        //
        public static void showMenuCustomer(List<Customer> list)
        {
            int choose;
            do
            {

                Console.WriteLine("1. Them khach hang");
                Console.WriteLine("2. Sua thong tin khach hang");
                Console.WriteLine("3. Xoa khach hang");
                Console.WriteLine("4. Danh sach khach hang");
                Console.WriteLine("5. Quay lai menu chinh");
                Console.WriteLine("Choose");
                choose = Convert.ToInt32(Console.ReadLine());
                switch (choose)
                {
                    case 1:
                        inputCustomer(list);
                        break;
                    case 2:
                        EditCustomer(list);
                        break;
                    case 3:
                        deletedCustomer(list);
                        break;
                    case 4:
                        Console.WriteLine("Danh sach khach hang");
                        foreach (var item in list)
                        {
                            item.display();
                        }
                        break;
                    case 5:
                        break;
                    default:
                        Console.WriteLine("Chon sai roi");
                        break;


                }
            } while (choose != 5);

        }
        public static void inputCustomer(List<Customer> list)
        {

            Console.WriteLine("Nhap N thong tin khang hang");
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                Customer customer = new Customer();
                customer.input();
                customer.display();
                list.Add(customer);
            }
        }

        //edit customer
        public static void EditCustomer(List<Customer> list)
        {
            Customer customer = searchCustomer(list);
            if (customer != null)
            {
                Console.WriteLine("Sua thong tin khach hang ");
                customer.input();
                Console.WriteLine("thong tin sau khi sua");
                foreach (var item in list)
                {
                    item.display();
                }
                return;
            }
            Console.WriteLine("Identitycard khong ton tai");
        }

        public static Customer searchCustomer(List<Customer> list)
        {
            Console.WriteLine("nhap Identitycard customer ");
            Customer ctm = null;
            int identitycard_customer = Convert.ToInt32(Console.ReadLine());
            foreach (var item in list)
            {
                if (item.Identitycard.Equals(identitycard_customer))
                {
                    ctm = item;
                    break;
                }
            }
            return ctm;
        }
        //deleted customer theo Identitycard
        public static void deletedCustomer(List<Customer> list)
        {

            Customer customer = searchCustomer(list);
            if (customer != null)
            {
                Console.WriteLine("Deleted thanh cong  Identitycard customer ={ 0}", customer.Identitycard);
                list.Remove(customer);
                return;
            }
            Console.WriteLine("Identitycard khong ton tai");
        }

        //code quan li dat phong
        //tim phong con trong
         public static void FindBookingAvaiable(List<Hotel> hotels, List<Book> books)
        {
            if (hotels.Count == 0)
            {
                Console.WriteLine("khong co data!!!");
                return;
            }

            Hotel currentHotel = null;
            for (; ; )
            {
                foreach (Hotel hotel in hotels)
                {
                    Console.WriteLine("Ma KS: {0}, Ten KS: {1}", hotel.Id_Hotel, hotel.NameHotel);
                }
                string HotelCode = Console.ReadLine();
                foreach (Hotel hotel in hotels)
                {
                    if (hotel.Id_Hotel.Equals(HotelCode))
                    {
                        currentHotel = hotel;
                        break;
                    }
                }
                if (currentHotel != null)
                {
                    break;
                }
                Console.WriteLine("(Not Found) Nhap lai: ");
            }
            if (currentHotel.ListRoom.Count == 0)
            {
                Console.WriteLine("khong co data!!!");
                return;
            }

            Console.WriteLine("Ngay CheckIn (dd/mm/YYYY): ");
            string dateTime = Console.ReadLine();
            DateTime CheckIn = DateTime.ParseExact(dateTime, "dd/MM/yyyy", null);

            Console.WriteLine("Ngay CheckOut (dd/mm/YYYY): ");
            dateTime = Console.ReadLine();
            DateTime CheckOut = DateTime.ParseExact(dateTime, "dd/MM/yyyy", null);

            //Tim kiem phong co the book
         
            foreach (Room room in currentHotel.ListRoom)
            {
                //Tim da danh sach booking cho phong room.
                List<Book> currentBooking = new List<Book>();
                foreach (Book book in books)
                {
                    if (book.Id_hotel.Equals(currentHotel.Id_Hotel) && book.Id_roomHotel.Equals(room.IdRoom))
                    {
                        currentBooking.Add(book);
                    }
                }
                //Kiem tra phong nay co kha nang book hay ko
                bool isFind = false;
                foreach (Book book in currentBooking)
                {
                    if (DateTime.Compare(book.CheckIn, CheckOut) > 0 || DateTime.Compare(book.CheckOut, CheckIn) < 0)
                    {
                        
                    }
                    else
                    {
                        isFind = true;
                        break;
                    }
                }

                if (!isFind)
                {
                    Console.WriteLine("Room No: {0}, Room Name: {1}", room.IdRoom, room.NameRoom);
                }
            }
        }

        //book hotel
        public static void Booking(List<Customer> customers, List<Hotel> hotels, List<Book> listbooks)
        {
            Book book = new Book();
            book.input(customers, hotels);
            listbooks.Add(book);

        }
        //in danh sach order book
        public static void showInfoBook(List<Book> listBook)
        {
            if (listBook.Count == 0)
            {
                Console.WriteLine("Chua co du lieu");
                return;
            }
            foreach (var item in listBook)
            {
                item.display();
            }
        }

        //showmeu tim kiem
        public static void ShowMenuSearch(List<Hotel> listHotel,List<Customer> listCustomer)
        {
            int choose;
            do
            {
                Console.WriteLine("1. Tim kiem khach san");
                Console.WriteLine("2. Tim kiem khach hang");
                Console.WriteLine("3. Huy");
                Console.WriteLine("Choose: ");
                choose = Convert.ToInt32(Console.ReadLine());
                switch (choose)
                {
                    case 1:
                        if (listHotel.Count == 0)
                        {
                            Console.WriteLine("Chua co data");
                            return;
                        }
                        Hotel ht = null;
                        ht = searchByID(listHotel);
                        if(ht == null)
                        {
                            Console.WriteLine("id hotel khong chinh xac");
                            return;                          
                        }
                        ht.display();
                        break;
                    case 2:
                        if (listCustomer.Count == 0)
                        {
                            Console.WriteLine("chua co data");
                            return;
                        }
                        Console.WriteLine("nhap Identitycard khach hang can tim");
                        int search = Convert.ToInt32(Console.ReadLine());
                        Customer currentCustomer = null;
                        foreach (var item in listCustomer)
                        {
                            if (item.Identitycard== search){
                                currentCustomer = item;
                                break;
                            }
                        }
                        if(currentCustomer != null)
                        {
                            Console.WriteLine("thong tin khach hang can tim");
                            currentCustomer.display();
                            return;
                        }
                        Console.WriteLine("IdentityCard khong tim thay");
                        break;
                    case 3:
                        break;
                    default:
                        Console.WriteLine("Chon lai di");
                        break;
                }

            } while (choose != 3);
            

        }


    }

}

