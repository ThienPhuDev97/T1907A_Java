using System;
using System.Collections.Generic;
using System.Text;

namespace QuanLiKhachSan
{
    class Book
    {
        public DateTime CheckIn { get; set; }
        public DateTime CheckOut { get; set; }
        public int Identitycard { get; set; }
        public string Id_hotel { get; set; }
        public string Id_roomHotel { get; set; }

        public Book() { }
        public void display()
        {
            Console.WriteLine("CheckIn={0},CheckOut={1},Identitycard={2},Id_hotel={3},Id_roomHotel{4}", CheckIn,
                CheckOut, Identitycard, Id_hotel, Id_roomHotel);
        }
        public void input(List<Customer> listCustomers, List<Hotel> hotels)
        {
            if (hotels.Count == 0)
            {
                Console.WriteLine("Chua co du lieu");
                return;
            }
            Console.WriteLine("Nhap CMND ");
            Identitycard = Convert.ToInt32(Console.ReadLine());
            bool ischeck = false;
            foreach (var item in listCustomers)
            {
                if (item.Identitycard.Equals(Identitycard))
                {
                    ischeck = true;
                    break;
                }
            }
            if (!ischeck)
            {
                Customer customer = new Customer();
                customer.Identitycard = Identitycard;
                customer.input2();
                listCustomers.Add(customer);
            }

            //kiem tra ma id hotel can tim
            Hotel currentHotel = null;

            for (; ; )
            {
                Console.WriteLine("Danh sach khach san");
                foreach (var item in hotels)
                {
                    Console.WriteLine("Id KS={0}, Ten KS = {1}", item.Id_Hotel, item.NameHotel);
                }
                Console.WriteLine("nhap id hotel");
                Id_hotel = Console.ReadLine();
                foreach (var item in hotels)
                {
                    if (item.Id_Hotel.Equals(Id_hotel))
                    {
                        currentHotel = item;
                        break;
                    }
                }
                //
                if (currentHotel == null)
                {
                    Console.WriteLine("chon sai roi,nhap lai");
                }
                else
                {
                    break;
                }

            }
            if (currentHotel.ListRoom.Count == 0)
            {
                Console.WriteLine("khach san khong cai dat phong");
                return;
            }

            //kiem tra phong
            for (; ; )
            {
                foreach (var item in currentHotel.ListRoom)
                {
                    Console.WriteLine("Id_room={0}, Name_room={1}", item.IdRoom, item.NameRoom);
                }
                var isFind = false;
                Console.WriteLine("nhap ma phong ");
                Id_roomHotel = Console.ReadLine();
                foreach (var item in currentHotel.ListRoom)
                {
                    if (item.IdRoom.Equals(Id_roomHotel))
                    {
                        isFind = true;
                        break;
                    }
                }
                if (isFind)
                {
                    break;
                }
                else
                {
                    Console.WriteLine("not find, nhap lai");
                }

            }

            Console.WriteLine("ngay check in (dd/mm/yyyy)");
            string dateTime = Console.ReadLine();
            CheckIn = ConvertStringToDatetime(dateTime);

            Console.WriteLine("ngay check in (dd/mm/yyyy)");
            dateTime = Console.ReadLine();
            CheckOut = ConvertStringToDatetime(dateTime);

           
           
            
        }
        public DateTime ConvertStringToDatetime(string value)
        {
            
            DateTime oDate = DateTime.ParseExact(value, "dd/MM/yyyy", null);

            return oDate;
        }
    }
}
