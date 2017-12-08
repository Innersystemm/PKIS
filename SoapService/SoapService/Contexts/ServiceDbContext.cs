using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using SoapService.EntityClasses;

namespace SoapService.Contexts
{
    public class ServiceDbContext : DbContext
    {
        public ServiceDbContext(string connectionString) : base(connectionString)
        {
            Configuration.AutoDetectChangesEnabled = true;
            Configuration.LazyLoadingEnabled = true;
            Configuration.ProxyCreationEnabled = true;
            Configuration.ValidateOnSaveEnabled = true;
            Database.SetInitializer(new ServiceDbInitializer());
        }
        public DbSet<Flat> Flats { get; set; }
        public DbSet<Deal> Deals { get; set; }
        public DbSet<Region> Regions { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Flat>()
            .HasMany(s => s.Deals)
            .WithRequired(s => s.Flat);

            modelBuilder.Entity<Region>()
               .HasMany(s => s.Flats)
               .WithRequired(s => s.Region);
            base.OnModelCreating(modelBuilder);
        }

        protected override void Dispose(bool disposing)
        {
            Configuration.LazyLoadingEnabled = false;
            base.Dispose(disposing);
        }
    }
    public class ServiceDbInitializer : DropCreateDatabaseAlways<ServiceDbContext>
    {
        protected override void Seed(ServiceDbContext context)
        {
            context.Configuration.AutoDetectChangesEnabled = false;
            context.Deals.AddRange(SeedDeals(15));
            context.Configuration.AutoDetectChangesEnabled = true;

        }

        protected List<Deal> SeedDeals(uint count = 25)
        {
            List<Deal> result = new List<Deal>();
            if (count < 1) return result;
            Random rand = new Random();
            string name = "some name";
            for (int index = 0; index < count; index++)
            {
                result.Add(new Deal()
                {
                    Date = DateTime.Today,
                    Price = rand.Next(100000, 10000000),
                    Flat = new Flat()
                    {
                        Area = rand.Next(10, 300),
                        Rooms = rand.Next(1, 6),
                        Balcony = Convert.ToBoolean(rand.Next(0, 1)),
                        Region = new Region()
                        {
                            Name = new string(name.Select(n => name.ElementAt(rand.Next(0, name.Length))).ToArray())
                        }
                    }
                });
            }
            return result;
        }
    }

}
