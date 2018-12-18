using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Third_Tier.Data.Entities;

namespace Third_Tier.Data
{
    public class UserContext : DbContext
    {
        public DbSet<User> Users { get; set; }

        public UserContext(DbContextOptions<UserContext> options) : base(options)
        {

        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>().HasData(
                new { email = "a@gmail.com", username = "John", password = "password1", score = 5, stage = 0 },
                new { email = "b@gmail.com", username = "Max", password = "password2", score = 87, stage = 5 },
                new { email = "c@gmail.com", username = "Daniela", password = "password3", score = 23, stage = 5 },
                new { email = "d@gmail.com", username = "Lukas", password = "password4", score = 50, stage = 6 },
                new { email = "e@gmail.com", username = "Alex", password = "password5", score = 50, stage = 7 },
                new { email = "f@gmail.com", username = "Ilie", password = "password6", score = 46, stage = 4 }

            );
        }
    }
}
