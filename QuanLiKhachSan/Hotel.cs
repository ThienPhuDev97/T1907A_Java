using System;
using System.Collections.Generic;
using System.Text;

namespace QuanLiKhachSan
{
    class Hotel
    {
        public string NameHotel { get; set; }
        public string AddressHotel { get; set; }
        public enum typehotel { Vip, Binhdan };
        public typehotel Typehotel { get; set; }

        
        public List<Room> ListRoom { get; set; }

        
        public string Id_Hotel { get; set; }

        public Hotel() 
        {
            ListRoom = new List<Room>();
        }

        public void inputHotel()
        {
            Console.WriteLine("input id hotel");
            Id_Hotel = Console.ReadLine();
            Console.WriteLine("input namehotel");
            NameHotel = Console.ReadLine();
            Console.WriteLine("input addressHotel");
            AddressHotel = Console.ReadLine();
            Console.WriteLine("input type hotel");
            checkTypeHotel();
            inputRoom();
            

        }
        public void display()
        {
            Console.WriteLine("id_hotel ={0},nameHotel={1},addressHotel={2},TypeHote={3}", Id_Hotel, NameHotel, AddressHotel, Typehotel);
            Console.WriteLine("listroom hotel {0} :", NameHotel);
            foreach (var item in ListRoom)
            {

                item.display();
            }
        }

        public void checkTypeHotel()
        {
            int choose;
            do
            {
                Console.WriteLine("0: Vip");
                Console.WriteLine("1: Binhdan");
                Console.WriteLine("Choose:");
                choose = Convert.ToInt32(Console.ReadLine());

                switch (choose)
                {
                    case 0:
                        Typehotel = typehotel.Vip;

                        break;
                    case 1:
                        Typehotel = typehotel.Binhdan;

                        break;

                    default:
                        Console.WriteLine("Chon lai di");
                        break;

                }
            } while (choose > 1 || choose < 0);

        }

        
        public void inputRoom()
        {
            Console.WriteLine("input N room in Hotel");
            int n = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                Room newroom = new Room();
                newroom.input();
                Console.WriteLine("room vua nhap");
                newroom.display();
                ListRoom.Add(newroom);
            }
        }
        //update hotel 
        public void updateHotel()
        {
            int choose;
            do
            {
                Console.WriteLine("1. Edit id hotel");
                Console.WriteLine("2. Eidt namehotel");
                Console.WriteLine("3. Edit address hotel");
                Console.WriteLine("4. Edit type hotel");
                Console.WriteLine("5. Edit room hotel");
                Console.WriteLine("6. Huy");
                choose = Convert.ToInt32(Console.ReadLine());

                switch (choose)
                {
                    case 1:
                        Console.WriteLine("input id hotel");
                        Id_Hotel = Console.ReadLine();
                        break;
                    case 2:
                        Console.WriteLine("input namehotel");
                        NameHotel = Console.ReadLine();
                        break;
                    case 3:
                        Console.WriteLine("input addressHotel");
                        AddressHotel = Console.ReadLine();
                        break;
                    case 4:
                        checkTypeHotel();
                        break;
                    case 5:
                        foreach (var item in ListRoom)
                        {
                            item.updateRoom();
                        }
                        break;
                    case 6:
                        Console.WriteLine("huy thanh cong");
                        break;
                    default:
                        Console.WriteLine("Chon lai di");
                        break;


                }
            } while (choose!=6);
        }
    }

}

