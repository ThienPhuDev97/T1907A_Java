using System;
using System.Collections.Generic;
using System.Text;

namespace QuanLiKhachSan
{
    class Room
    {
        public string NameRoom { get; set; }
        public int PriceRoom { get; set; }
        public string NameFloor { get; set; } // tên tầng
        public int CountMaxRoom { get; set; }
        public string IdRoom { get; set; }

        public Room() { }
        public Room(string nameRoom, int priceroom, string nameFloor, int countmaxRoom, string idRoom)
        {
            NameRoom = nameFloor;
            PriceRoom = priceroom;
            NameFloor = nameFloor;
            CountMaxRoom = countmaxRoom;
            IdRoom = idRoom;
        }
        public void display()
        {
            Console.WriteLine("nameRoom={0},priceRoom = {1},nameFloor={2},countMaxRoom ={3},Idroom={4}", NameRoom,
                PriceRoom, NameFloor, CountMaxRoom, IdRoom);
        }
        public void input()
        {
            Console.WriteLine("input idroom");
            IdRoom = Console.ReadLine();
            Console.WriteLine("input nameRoom");
            NameRoom = Console.ReadLine();
            Console.WriteLine("input priceRoom");
            PriceRoom = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("input nameFloor");
            NameFloor = Console.ReadLine();
            Console.WriteLine("input CountMaxRoom");
            CountMaxRoom = Convert.ToInt32(Console.ReadLine());

        }
        public void updateRoom()
        {
            int choose;

            do
            {
                Console.WriteLine("1. edit id room");
                Console.WriteLine("2. edit NameRoom");
                Console.WriteLine("3. edit PriceRoom");
                Console.WriteLine("4. edit NameFloor");
                Console.WriteLine("5. edit CountMaxRoom");
                Console.WriteLine("Huy");
                Console.WriteLine("Choose");
                choose = Convert.ToInt32(Console.ReadLine());
                switch (choose)
                {
                    case 1:
                        Console.WriteLine("input idroom");
                        IdRoom = Console.ReadLine();
                        break;
                    case 2:
                        Console.WriteLine("input nameRoom");
                        NameRoom = Console.ReadLine();
                        break;
                    case 3:
                        Console.WriteLine("input priceRoom");
                        PriceRoom = Convert.ToInt32(Console.ReadLine());
                        break;
                    case 4:
                        Console.WriteLine("input nameFloor");
                        NameFloor = Console.ReadLine();
                        break;
                    case 5:
                        Console.WriteLine("input CountMaxRoom");
                        CountMaxRoom = Convert.ToInt32(Console.ReadLine());
                        break;
                    case 6:
                        Console.WriteLine("huy thanh cong");
                        break;
                    default:
                        Console.WriteLine("chon sai roi, chon lai tu 1-6");
                        break;

                }
            } while (choose != 6);
        }
    }
}
